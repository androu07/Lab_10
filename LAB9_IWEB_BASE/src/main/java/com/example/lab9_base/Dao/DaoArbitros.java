package com.example.lab9_base.Dao;

import com.example.lab9_base.Bean.Arbitro;;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoArbitros extends DaoBase{

    public static ArrayList<Arbitro> listarArbitros() {
        ArrayList<Arbitro> arbitros = new ArrayList<>();;
        String sql = "SELECT nombre, pais FROM arbitro;";

        try {
            Connection conn = this.getConnection();

            try {
                Statement stmt = conn.createStatement();

                try {
                    ResultSet rs = stmt.executeQuery(sql);

                    try {
                        while(rs.next()) {
                            Arbitro arbitro = this.fetchArbitroData(rs);
                            arbitros.add(arbitro);
                        }
                    } catch (Throwable var11) {
                        if (rs != null) {
                            try {
                                rs.close();
                            } catch (Throwable var10) {
                                var11.addSuppressed(var10);
                            }
                        }

                        throw var11;
                    }

                    if (rs != null) {
                        rs.close();
                    }
                } catch (Throwable var12) {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (Throwable var9) {
                            var12.addSuppressed(var9);
                        }
                    }

                    throw var12;
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable var13) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var8) {
                        var13.addSuppressed(var8);
                    }
                }

                throw var13;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var14) {
            var14.printStackTrace();
        }

        return arbitros;
    }

    public static void crearArbitro(String nombre, String pais) {
        String sql = "INSERT INTO arbitro (nombre, pais) VALUES (?,?,?,?)";

        try {
            Connection conn = this.getConnection();

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);

                try {
                    pstmt.setString(1, nombre);
                    pstmt.setString(2, pais);
                    pstmt.executeUpdate();
                } catch (Throwable var12) {
                    if (pstmt != null) {
                        try {
                            pstmt.close();
                        } catch (Throwable var11) {
                            var12.addSuppressed(var11);
                        }
                    }

                    throw var12;
                }

                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Throwable var13) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var10) {
                        var13.addSuppressed(var10);
                    }
                }

                throw var13;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var14) {
            var14.printStackTrace();
        }
    }

    public Arbitro busquedaPais(String pais) {

        Arbitro arbitro = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException var15) {
            throw new RuntimeException(var15);
        }

        String url = "jdbc:mysql://localhost:3306/bicicentro";
        String username = "root";
        String password = "123456";
        String sql = "select * from arbitro where pais = ?";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);

                try {
                    pstmt.setString(1, pais);
                    ResultSet rs = pstmt.executeQuery();

                    try {
                        while(rs.next()) {
                            arbitro = new Arbitro();
                            arbitro.setNombre(rs.getString(1));
                        }
                    } catch (Throwable var16) {
                        if (rs != null) {
                            try {
                                rs.close();
                            } catch (Throwable var14) {
                                var16.addSuppressed(var14);
                            }
                        }

                        throw var16;
                    }

                    if (rs != null) {
                        rs.close();
                    }
                } catch (Throwable var17) {
                    if (pstmt != null) {
                        try {
                            pstmt.close();
                        } catch (Throwable var13) {
                            var17.addSuppressed(var13);
                        }
                    }

                    throw var17;
                }

                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Throwable var18) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var12) {
                        var18.addSuppressed(var12);
                    }
                }

                throw var18;
            }

            if (conn != null) {
                conn.close();
            }

            return arbitro;
        } catch (SQLException var19) {
            throw new RuntimeException(var19);
        }
    }

    public Arbitro busquedaNombre(String nombre) {

        Arbitro arbitro = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException var15) {
            throw new RuntimeException(var15);
        }

        String url = "jdbc:mysql://localhost:3306/bicicentro";
        String username = "root";
        String password = "123456";
        String sql = "select * from arbitro where nombre = ?";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);

                try {
                    pstmt.setString(1, nombre);
                    ResultSet rs = pstmt.executeQuery();

                    try {
                        while(rs.next()) {
                            arbitro = new Arbitro();
                            arbitro.setNombre(rs.getString(1));
                        }
                    } catch (Throwable var16) {
                        if (rs != null) {
                            try {
                                rs.close();
                            } catch (Throwable var14) {
                                var16.addSuppressed(var14);
                            }
                        }

                        throw var16;
                    }

                    if (rs != null) {
                        rs.close();
                    }
                } catch (Throwable var17) {
                    if (pstmt != null) {
                        try {
                            pstmt.close();
                        } catch (Throwable var13) {
                            var17.addSuppressed(var13);
                        }
                    }

                    throw var17;
                }

                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Throwable var18) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var12) {
                        var18.addSuppressed(var12);
                    }
                }

                throw var18;
            }

            if (conn != null) {
                conn.close();
            }

            return arbitro;
        } catch (SQLException var19) {
            throw new RuntimeException(var19);
        }
    }

    public static Arbitro buscarArbitro(int idArbitro) {
        Arbitro arbitro = null;
        String sql = "SELECT * FROM arbitro WHERE idArbitro = ?";

        try {
            Connection conn = this.getConnection();

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);

                try {
                    pstmt.setInt(1, idArbitro);
                    ResultSet rs = pstmt.executeQuery();

                    try {
                        if (rs.next()) {
                            arbitro = new Arbitro();
                            arbitro.setIdArbitro(rs.getInt(1));
                            arbitro.setNombre(rs.getString(2));
                            arbitro.setPais(rs.getString(3));
                        }
                    } catch (Throwable var12) {
                        if (rs != null) {
                            try {
                                rs.close();
                            } catch (Throwable var11) {
                                var12.addSuppressed(var11);
                            }
                        }

                        throw var12;
                    }

                    if (rs != null) {
                        rs.close();
                    }
                } catch (Throwable var13) {
                    if (pstmt != null) {
                        try {
                            pstmt.close();
                        } catch (Throwable var10) {
                            var13.addSuppressed(var10);
                        }
                    }

                    throw var13;
                }

                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Throwable var14) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var9) {
                        var14.addSuppressed(var9);
                    }
                }

                throw var14;
            }

            if (conn != null) {
                conn.close();
            }

            return arbitro;
        } catch (SQLException var15) {
            throw new RuntimeException(var15);
        }
    }

    public static void borrarArbitro(int idArbitro) {
        String sql = "DELETE FROM arbitro WHERE idArbitro = ?";

        try {
            Connection conn = this.getConnection();

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);

                try {
                    pstmt.setInt(1, idArbitro);
                    pstmt.executeUpdate();
                } catch (Throwable var9) {
                    if (pstmt != null) {
                        try {
                            pstmt.close();
                        } catch (Throwable var8) {
                            var9.addSuppressed(var8);
                        }
                    }

                    throw var9;
                }

                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Throwable var10) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var7) {
                        var10.addSuppressed(var7);
                    }
                }

                throw var10;
            }

            if (conn != null) {
                conn.close();
            }

        } catch (SQLException var11) {
            throw new RuntimeException(var11);
        }
    }

    private Arbitro fetchArbitroData(ResultSet rs) throws SQLException {
        Arbitro arbitro = new Arbitro();
        arbitro.setNombre(rs.getString(1));
        arbitro.setPais(rs.getString(2));
        return arbitro;
    }
}