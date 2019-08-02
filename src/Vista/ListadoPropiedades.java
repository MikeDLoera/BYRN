package Vista;

/**
 *
 * @author CST-UTJ
 */
public class ListadoPropiedades extends javax.swing.JPanel {

    /**
     * Creates new form ListadoPropiedades
     */
    public ListadoPropiedades() {
        initComponents();
        
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jListadoDePropiedades = new javax.swing.JPanel();
        panlListadoDePropiedades = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        lbListadoDePropiedades = new javax.swing.JLabel();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnEliminarPropiedad = new javax.swing.JButton();
        btnEditarPropiedad = new javax.swing.JButton();
        btnMasInformacion = new javax.swing.JButton();
        btnAnadirPropiedad = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        clockDigital1 = new org.edisoncor.gui.varios.ClockDigital();
        btnFiltrarCasas = new javax.swing.JButton();
        btnFiltrarTerrenos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListadoDePropiedades = new rojerusan.RSTableMetro();
        panImagenDePropiedades = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panImagenDePropiedaes = new org.edisoncor.gui.panel.PanelImage();
        btnSiguente = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtBuscador = new javax.swing.JTextField();
        btnBusqueda = new javax.swing.JButton();

        setBackground(new java.awt.Color(143, 198, 94));

        jListadoDePropiedades.setBackground(new java.awt.Color(233, 248, 223));
        jListadoDePropiedades.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        panlListadoDePropiedades.setBackground(new java.awt.Color(255, 255, 255));
        panlListadoDePropiedades.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbTitulo.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lbTitulo.setText("Listado de Propiedades");

        lbListadoDePropiedades.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lbListadoDePropiedades.setText("Listado de Propiedades");

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/ListaGrande.png"))); // NOI18N

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 83, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel2.setText("Propiedades");

        javax.swing.GroupLayout panlListadoDePropiedadesLayout = new javax.swing.GroupLayout(panlListadoDePropiedades);
        panlListadoDePropiedades.setLayout(panlListadoDePropiedadesLayout);
        panlListadoDePropiedadesLayout.setHorizontalGroup(
            panlListadoDePropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panlListadoDePropiedadesLayout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panlListadoDePropiedadesLayout.createSequentialGroup()
                .addContainerGap(443, Short.MAX_VALUE)
                .addGroup(panlListadoDePropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panlListadoDePropiedadesLayout.createSequentialGroup()
                        .addComponent(lbListadoDePropiedades)
                        .addGap(464, 464, 464))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panlListadoDePropiedadesLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(199, 199, 199)
                        .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );
        panlListadoDePropiedadesLayout.setVerticalGroup(
            panlListadoDePropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panlListadoDePropiedadesLayout.createSequentialGroup()
                .addGroup(panlListadoDePropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panlListadoDePropiedadesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panlListadoDePropiedadesLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)))
                .addGap(202, 202, 202)
                .addComponent(lbListadoDePropiedades)
                .addGap(96, 96, 96)
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnEliminarPropiedad.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnEliminarPropiedad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/borrar (1).png"))); // NOI18N
        btnEliminarPropiedad.setText("Eliminar");
        btnEliminarPropiedad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnEditarPropiedad.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnEditarPropiedad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/editar.png"))); // NOI18N
        btnEditarPropiedad.setText("Editar");
        btnEditarPropiedad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnMasInformacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnMasInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/informacion.png"))); // NOI18N
        btnMasInformacion.setText("Más Información");
        btnMasInformacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAnadirPropiedad.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnAnadirPropiedad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/mas.png"))); // NOI18N
        btnAnadirPropiedad.setText("Añadir");
        btnAnadirPropiedad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnExcel.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/Excel.png"))); // NOI18N
        btnExcel.setText("Exportar listado en Excel");
        btnExcel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        clockDigital1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        btnFiltrarCasas.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnFiltrarCasas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/casa.png"))); // NOI18N
        btnFiltrarCasas.setText("Solo Casas");
        btnFiltrarCasas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnFiltrarTerrenos.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnFiltrarTerrenos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/terreno.png"))); // NOI18N
        btnFiltrarTerrenos.setText("Solo Terrenos");
        btnFiltrarTerrenos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAnadirPropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarPropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditarPropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMasInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFiltrarCasas, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFiltrarTerrenos)
                .addGap(18, 18, 18)
                .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clockDigital1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clockDigital1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAnadirPropiedad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarPropiedad)
                        .addComponent(btnEditarPropiedad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMasInformacion)
                        .addComponent(btnExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFiltrarTerrenos)
                        .addComponent(btnFiltrarCasas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tblListadoDePropiedades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Onyx", "Alan Sebastian Castañeda", null},
                {"2", "Ambar", "Aaron Gomez Rodriguez", null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Número de Propiedad", "Nombre", "Dueño", "Tipo"
            }
        ));
        tblListadoDePropiedades.setColorBackgoundHead(new java.awt.Color(40, 153, 118));
        tblListadoDePropiedades.setColorFilasBackgound2(new java.awt.Color(233, 248, 223));
        tblListadoDePropiedades.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tblListadoDePropiedades.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tblListadoDePropiedades.setColorSelBackgound(new java.awt.Color(0, 0, 0));
        tblListadoDePropiedades.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tblListadoDePropiedades.setFuenteFilas(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tblListadoDePropiedades.setFuenteFilasSelect(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tblListadoDePropiedades.setFuenteHead(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jScrollPane2.setViewportView(tblListadoDePropiedades);

        panImagenDePropiedades.setBackground(new java.awt.Color(255, 255, 255));
        panImagenDePropiedades.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel1.setText("Foto de la propiedad");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        panImagenDePropiedaes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panImagenDePropiedaesLayout = new javax.swing.GroupLayout(panImagenDePropiedaes);
        panImagenDePropiedaes.setLayout(panImagenDePropiedaesLayout);
        panImagenDePropiedaesLayout.setHorizontalGroup(
            panImagenDePropiedaesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        panImagenDePropiedaesLayout.setVerticalGroup(
            panImagenDePropiedaesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );

        btnSiguente.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnSiguente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/flecha-derecha.png"))); // NOI18N
        btnSiguente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAnterior.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/espalda.png"))); // NOI18N
        btnAnterior.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panImagenDePropiedadesLayout = new javax.swing.GroupLayout(panImagenDePropiedades);
        panImagenDePropiedades.setLayout(panImagenDePropiedadesLayout);
        panImagenDePropiedadesLayout.setHorizontalGroup(
            panImagenDePropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panImagenDePropiedadesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSiguente, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panImagenDePropiedadesLayout.createSequentialGroup()
                .addGroup(panImagenDePropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panImagenDePropiedadesLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1))
                    .addGroup(panImagenDePropiedadesLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(panImagenDePropiedaes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panImagenDePropiedadesLayout.setVerticalGroup(
            panImagenDePropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panImagenDePropiedadesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panImagenDePropiedaes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(panImagenDePropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSiguente, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jLabel3.setText("Buscador:");

        txtBuscador.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        btnBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/busqueda.png"))); // NOI18N
        btnBusqueda.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jListadoDePropiedadesLayout = new javax.swing.GroupLayout(jListadoDePropiedades);
        jListadoDePropiedades.setLayout(jListadoDePropiedadesLayout);
        jListadoDePropiedadesLayout.setHorizontalGroup(
            jListadoDePropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jListadoDePropiedadesLayout.createSequentialGroup()
                .addGroup(jListadoDePropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panlListadoDePropiedades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jListadoDePropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jListadoDePropiedadesLayout.createSequentialGroup()
                            .addGroup(jListadoDePropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jListadoDePropiedadesLayout.createSequentialGroup()
                                    .addGap(276, 276, 276)
                                    .addComponent(jLabel3)
                                    .addGap(52, 52, 52)
                                    .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(btnBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jListadoDePropiedadesLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panImagenDePropiedades, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jListadoDePropiedadesLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jListadoDePropiedadesLayout.setVerticalGroup(
            jListadoDePropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jListadoDePropiedadesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(panlListadoDePropiedades, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jListadoDePropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jListadoDePropiedadesLayout.createSequentialGroup()
                        .addGroup(jListadoDePropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jListadoDePropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtBuscador)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jListadoDePropiedadesLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnBusqueda)))
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panImagenDePropiedades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jListadoDePropiedades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jListadoDePropiedades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAnadirPropiedad;
    public javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnBusqueda;
    public javax.swing.JButton btnEditarPropiedad;
    public javax.swing.JButton btnEliminarPropiedad;
    public javax.swing.JButton btnExcel;
    public javax.swing.JButton btnFiltrarCasas;
    public javax.swing.JButton btnFiltrarTerrenos;
    public javax.swing.JButton btnMasInformacion;
    public javax.swing.JButton btnSiguente;
    private org.edisoncor.gui.varios.ClockDigital clockDigital1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JPanel jListadoDePropiedades;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbListadoDePropiedades;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel panImagenDePropiedades;
    public org.edisoncor.gui.panel.PanelImage panImagenDePropiedaes;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    public javax.swing.JPanel panlListadoDePropiedades;
    public rojerusan.RSTableMetro tblListadoDePropiedades;
    private javax.swing.JTextField txtBuscador;
    // End of variables declaration//GEN-END:variables
}
