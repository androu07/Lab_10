package com.example.lab9_base.Dao;

import com.example.lab9_base.Bean.Arbitro;
import com.example.lab9_base.Bean.Partido;
import com.example.lab9_base.Bean.SeleccionNacional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoPartidos extends DaoBase{
    public ArrayList<Partido> listaDePartidos() {

        ArrayList<Partido> partidos = new ArrayList<>();

        String sql = "select * from partido p\n" +
                "inner join seleccion l on p.seleccionLocal = l.idSeleccion\n" +
                "left join seleccion v on p.seleccionVisitante = v.idSeleccion\n" +
                "left join arbitro a on p.arbitro = a.idArbitro";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Partido partido = fetchPartidoData(rs);
                partidos.add(partido);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return partidos;

    }

    public void crearPartido(Partido partido) {

        /*
        Inserte su código aquí
        */
    }

    private Partido fetchPartidoData(ResultSet rs) throws SQLException {
        Partido partido = new Partido();
        partido.setIdPartido(rs.getInt(1));
        partido.setNumeroJornada(rs.getInt(6));
        partido.setFecha(rs.getString(5));

        SeleccionNacional seleccionNacionalLocal = new SeleccionNacional();
        seleccionNacionalLocal.setIdSeleccion(rs.getInt("p.seleccionLocal"));
        seleccionNacionalLocal.setNombre(rs.getString("l.nombre"));

        partido.setSeleccionLocal(seleccionNacionalLocal);

        SeleccionNacional seleccionNacionalVisitante = new SeleccionNacional();
        seleccionNacionalVisitante.setIdSeleccion(rs.getInt("p.seleccionVisitante"));
        seleccionNacionalVisitante.setNombre(rs.getString("v.nombre"));

        partido.setSeleccionVisitante(seleccionNacionalVisitante);

        Arbitro arbitro = new Arbitro();
        arbitro.setIdArbitro(rs.getInt("p.arbitro"));
        arbitro.setNombre(rs.getString("a.nombre"));

        partido.setArbitro(arbitro);


        return partido;
    }


}

