package br.com.duxusdesafio.model;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Jogador;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Posicao;
import br.edu.ifsul.modelo.Time;
import br.edu.ifsul.modelo.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FabricaObjetos {

    public static List<Time> carregaTimes(){
        List<Time> lista = new ArrayList<>();
        Time t = new Time();
        t.setId(1);
        t.setNome("Grêmio");
        t.setDataFundacao(Calendar.getInstance());
        t.setHistoria("<h1>Campeão do Mundo em 1983</h1><h1>Campeão do Mundo em 1983</h1>"
                + "<h1>Campeão do Mundo em 1983</h1><h1>Campeão do Mundo em 1983</h1>");
        Cidade c = new Cidade();
        c.setNome("Porto Alegre");
        t.setCidade(c);
        Pessoa tecnico = new Pessoa();
        tecnico.setNome("Renato");
        t.setTecnico(tecnico);
        Usuario u = new Usuario();
        u.setNome("Jorge");
        t.setUsuario(u);
        lista.add(t);
        Posicao p = new Posicao();
        p.setNome("Goleiro");
        Jogador j = new Jogador();
        j.setNome("Marcelo");
        j.setNascimento(Calendar.getInstance());
        j.setPosicao(p);
        j.setAltura(1.84);
        j.setPeso(90.0);
        t.getJogadores().add(j);
        return lista;
    }

}
