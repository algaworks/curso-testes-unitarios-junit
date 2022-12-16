package com.algaworks.junit.blog.negocio;

import com.algaworks.junit.blog.exception.PostNaoEncontradoException;
import com.algaworks.junit.blog.exception.RegraNegocioException;
import com.algaworks.junit.blog.armazenamento.ArmazenamentoPost;
import com.algaworks.junit.blog.modelo.Post;
import com.algaworks.junit.blog.modelo.Notificacao;
import com.algaworks.junit.blog.utilidade.ConversorSlug;

import java.time.OffsetDateTime;
import java.util.Objects;

public class CadastroPost {

    //Não temos essa implementação, pois nesse projeto não sabemos nem qual framework vamos usar
    private final ArmazenamentoPost armazenamentoPost;
    private final CalculadoraGanhos calculadoraGanhos;
    private final GerenciadorNotificacao gerenciadorNotificacao;

    public CadastroPost(ArmazenamentoPost armazenamentoPost,
                        CalculadoraGanhos calculadoraGanhos,
                        GerenciadorNotificacao gerenciadorNotificacao) {
        this.armazenamentoPost = armazenamentoPost;
        this.calculadoraGanhos = calculadoraGanhos;
        this.gerenciadorNotificacao = gerenciadorNotificacao;
    }

    /*
     * Testar se calculou ganhos? ou apenas se chamou? Testar propriedades que foram setadas?
     * Testar calculo do ganho apenas no service que calcula
     * Verificar se ganhos e slug não estão nulos
     * Apos testar tudo, mover testes para classes respectivas
     * Cada classe de teste, testa apenas as regras da propria classe testada
     * Devemos testar o service chama as outras classes ou apenas o resultado
     */
    public Post criar(Post post) {
        Objects.requireNonNull(post);
        post.setSlug(criarSlug(post)); //precisa de mock? pode fazer teste falhar
        post.setGanhos(this.calculadoraGanhos.calcular(post)); //mock
        post = armazenamentoPost.salvar(post);
        enviarNotificacao(post);
        return post;
    }

    public Post editar(Post postAtualizado) {
        Objects.requireNonNull(postAtualizado);

        Post post = this.armazenamentoPost.encontrarPorId(postAtualizado.getId())
                .orElseThrow(PostNaoEncontradoException::new);
        post.atualizarComDados(post);

        if (!post.isPago()) {
            post.setGanhos(this.calculadoraGanhos.calcular(post)); //mock
        }

        return armazenamentoPost.salvar(post);
    }

    public void remover(Long postId) {
        Objects.requireNonNull(postId);
        Post post = this.armazenamentoPost.encontrarPorId(postId)
                .orElseThrow(PostNaoEncontradoException::new);
        if (post.isPublicado()) {
            throw new RegraNegocioException("Um post publicado não pode ser removido");
        }
        if (post.isPago()) {
            throw new RegraNegocioException("Um post pago não pode ser removido");
        }
        this.armazenamentoPost.remover(postId);
    }

    private String criarSlug(Post post) {
        return ConversorSlug.converterJuntoComCodigo(post.getTitulo());
    }

    private void enviarNotificacao(Post post) { //captor
        Notificacao notificacao = new Notificacao(
                OffsetDateTime.now(),
                "Novo post criado -> " + post.getTitulo() //Precisa testar isso? Construtor estático? refatorar?
        );
        this.gerenciadorNotificacao.enviar(notificacao);
    }
}
