package model;

import staff.Veterinarian;
import sahiplendirme.Quiz;
import sahiplendirme.ResultEvaluator;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

/**
 * PetClinic - Veteriner Yönetim Sistemi
 * Ana GUI Sınıfı
 */
public class GUI extends JFrame {

    // ── Renkler ─────────────────────────────────────────────────────────────
    private static final Color BG_DARK       = new Color(13, 17, 23);
    private static final Color BG_CARD       = new Color(22, 27, 34);
    private static final Color BG_HOVER      = new Color(30, 37, 46);
    private static final Color ACCENT_TEAL   = new Color(32, 201, 151);
    private static final Color ACCENT_BLUE   = new Color(56, 139, 253);
    private static final Color ACCENT_PURPLE = new Color(139, 92, 246);
    private static final Color ACCENT_ORANGE = new Color(251, 146, 60);
    private static final Color TEXT_PRIMARY  = new Color(230, 237, 243);
    private static final Color TEXT_MUTED    = new Color(125, 133, 144);
    private static final Color BORDER_COLOR  = new Color(48, 54, 61);

    // ── Fontlar ──────────────────────────────────────────────────────────────
    private static final Font FONT_TITLE  = new Font("Segoe UI", Font.BOLD, 28);
    private static final Font FONT_HEADER = new Font("Segoe UI", Font.BOLD, 16);
    private static final Font FONT_BODY   = new Font("Segoe UI", Font.PLAIN, 14);
    private static final Font FONT_SMALL  = new Font("Segoe UI", Font.PLAIN, 12);
    private static final Font FONT_MONO   = new Font("Consolas", Font.PLAIN, 13);

    // ── Veriler ──────────────────────────────────────────────────────────────
    private Animal[] hayvanlar = new Animal[100];
    private int hayvanSayisi   = 0;

    private Owner owner = new Owner("Yağmur", "Rümişoğlu", "111-2222-3333", "feyza@mail.com",
            new Address("Atatürk Cad.", "İstanbul", "34000"));

    private Veterinarian[] vets = {
        new Veterinarian("Dr. Ali Yılmaz",  "ali@mail.com",    "555-111",
                         "Veteriner Cerrahi",                  new String[]{"Pazartesi","Çarşamba","Cuma"}),
        new Veterinarian("Dr. Ayşe Kaya",   "ayse@mail.com",   "555-222",
                         "Veteriner Dahiliye",                  new String[]{"Salı","Perşembe"}),
        new Veterinarian("Dr. Mehmet Öz",   "mehmet@mail.com", "555-333",
                         "Veteriner Acil Tıp ve Yoğun Bakım",  new String[]{"Pazartesi","Salı","Cuma"})
    };

    // ── Bileşenler ───────────────────────────────────────────────────────────
    private JPanel contentPanel;
    private CardLayout cardLayout;
    private DefaultTableModel animalTableModel;

    public GUI() {
        setTitle("🐾 PetClinic — Veteriner Yönetim Sistemi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 750);
        setMinimumSize(new Dimension(900, 600));
        setLocationRelativeTo(null);

        getContentPane().setBackground(BG_DARK);
        setLayout(new BorderLayout());

        // KRİTİK DÜZELTME: Önce mainArea (cardLayout burada oluşuyor)
        add(buildMainArea(),    BorderLayout.CENTER);
        // Sonra sidebar (butonlar cardLayout'u kullanıyor)
        add(buildSidebar(),     BorderLayout.WEST);

        setVisible(true);
    }

    private JPanel buildSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setBackground(BG_CARD);
        sidebar.setPreferredSize(new Dimension(220, 0));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, BORDER_COLOR));

        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 16, 20));
        logoPanel.setBackground(BG_CARD);
        logoPanel.setMaximumSize(new Dimension(220, 70));

        JLabel logoIcon = new JLabel("🐾");
        logoIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 28));

        JPanel logoText = new JPanel();
        logoText.setBackground(BG_CARD);
        logoText.setLayout(new BoxLayout(logoText, BoxLayout.Y_AXIS));
        JLabel appName = new JLabel("PetClinic");
        appName.setFont(new Font("Segoe UI", Font.BOLD, 17));
        appName.setForeground(TEXT_PRIMARY);
        JLabel appSub = new JLabel("Vet Sistemi");
        appSub.setFont(FONT_SMALL);
        appSub.setForeground(ACCENT_TEAL);
        logoText.add(appName);
        logoText.add(appSub);

        logoPanel.add(logoIcon);
        logoPanel.add(logoText);
        sidebar.add(logoPanel);

        sidebar.add(makeSeparator());
        sidebar.add(Box.createVerticalStrut(8));

        String[][] menuItems = {
            {"🏠", "Ana Sayfa",       "home"},
            {"🐶", "Hayvan Ekle",      "add_animal"},
            {"📋", "Hayvan Listesi",   "animal_list"},
            {"📅", "Randevu Al",       "appointment"},
            {"💉", "Tıbbi Kayıt",      "medical"},
            {"🎯", "Sahiplendirme",    "adoption"},
            {"👨‍⚕️", "Veterinerler",   "vets"},
        };

        ButtonGroup group = new ButtonGroup();
        for (String[] item : menuItems) {
            JToggleButton btn = buildMenuButton(item[0], item[1], item[2]);
            group.add(btn);
            sidebar.add(btn);
            sidebar.add(Box.createVerticalStrut(2));
            if (item[2].equals("home")) btn.setSelected(true);
        }

        sidebar.add(Box.createVerticalGlue());
        sidebar.add(makeSeparator());

        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 12));
        userPanel.setBackground(BG_CARD);
        userPanel.setMaximumSize(new Dimension(220, 60));
        JLabel userIcon = new JLabel("👤");
        userIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 20));
        JLabel userName = new JLabel(owner.getFullName());
        userName.setFont(FONT_SMALL);
        userName.setForeground(TEXT_MUTED);
        userPanel.add(userIcon);
        userPanel.add(userName);
        sidebar.add(userPanel);

        return sidebar;
    }

    private JToggleButton buildMenuButton(String icon, String label, String card) {
        JToggleButton btn = new JToggleButton(icon + "  " + label) {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                if (isSelected()) {
                    g2.setColor(new Color(ACCENT_TEAL.getRed(), ACCENT_TEAL.getGreen(), ACCENT_TEAL.getBlue(), 30));
                    g2.fillRoundRect(8, 2, getWidth()-16, getHeight()-4, 8, 8);
                } else if (getModel().isRollover()) {
                    g2.setColor(BG_HOVER);
                    g2.fillRoundRect(8, 2, getWidth()-16, getHeight()-4, 8, 8);
                }
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btn.setFont(FONT_BODY);
        btn.setForeground(TEXT_MUTED);
        btn.setBackground(new Color(0,0,0,0));
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setMaximumSize(new Dimension(220, 40));
        btn.setPreferredSize(new Dimension(220, 40));
        btn.setBorder(BorderFactory.createEmptyBorder(0, 16, 0, 0));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btn.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                btn.setForeground(ACCENT_TEAL);
                cardLayout.show(contentPanel, card);
            } else {
                btn.setForeground(TEXT_MUTED);
            }
        });
        return btn;
    }

    private JPanel buildMainArea() {
        cardLayout   = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.setBackground(BG_DARK);

        contentPanel.add(buildHomePage(),        "home");
        contentPanel.add(buildAddAnimalPage(),  "add_animal");
        contentPanel.add(buildAnimalListPage(), "animal_list");
        contentPanel.add(buildAppointmentPage(),"appointment");
        contentPanel.add(buildMedicalPage(),    "medical");
        contentPanel.add(buildAdoptionPage(),   "adoption");
        contentPanel.add(buildVetsPage(),       "vets");

        return contentPanel;
    }

    private JPanel buildHomePage() {
        JPanel page = darkPage();
        page.setLayout(new BorderLayout(20, 20));
        page.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(BG_DARK);
        JLabel title = new JLabel("İyi Günler, " + owner.getFullName() + "! 👋");
        title.setFont(FONT_TITLE);
        title.setForeground(TEXT_PRIMARY);
        JLabel subtitle = new JLabel("PetClinic Veteriner Yönetim Sistemine Hoşgeldiniz");
        subtitle.setFont(FONT_BODY);
        subtitle.setForeground(TEXT_MUTED);
        header.add(title, BorderLayout.NORTH);
        header.add(subtitle, BorderLayout.CENTER);
        page.add(header, BorderLayout.NORTH);

        JPanel statsRow = new JPanel(new GridLayout(1, 4, 16, 0));
        statsRow.setBackground(BG_DARK);
        statsRow.add(buildStatCard("🐾", "Kayıtlı Hayvan", String.valueOf(hayvanSayisi), ACCENT_TEAL));
        statsRow.add(buildStatCard("👨‍⚕️", "Veteriner", String.valueOf(vets.length), ACCENT_BLUE));
        statsRow.add(buildStatCard("📅", "Randevu", "—", ACCENT_PURPLE));
        statsRow.add(buildStatCard("💉", "Aşı Kaydı", "—", ACCENT_ORANGE));
        page.add(statsRow, BorderLayout.CENTER);

        JPanel quickPanel = new JPanel(new GridLayout(1, 3, 16, 0));
        quickPanel.setBackground(BG_DARK);
        quickPanel.add(buildQuickCard("🐶", "Hayvan Ekle", "Yeni hasta kaydı oluştur", ACCENT_TEAL));
        quickPanel.add(buildQuickCard("📅", "Randevu Al", "Veteriner seçerek randevu oluştur", ACCENT_BLUE));
        quickPanel.add(buildQuickCard("🎯", "Sahiplendirme", "Sana uygun hayvanı bul", ACCENT_PURPLE));
        page.add(quickPanel, BorderLayout.SOUTH);

        return page;
    }

    private JPanel buildStatCard(String icon, String label, String value, Color accent) {
        JPanel card = new JPanel();
        card.setBackground(BG_CARD);
        card.setBorder(BorderFactory.createCompoundBorder(
            new RoundedBorder(12, BORDER_COLOR),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel ico = new JLabel(icon);
        ico.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 28));
        ico.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel val = new JLabel(value);
        val.setFont(new Font("Segoe UI", Font.BOLD, 32));
        val.setForeground(accent);
        val.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lbl = new JLabel(label);
        lbl.setFont(FONT_SMALL);
        lbl.setForeground(TEXT_MUTED);
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(ico); card.add(Box.createVerticalStrut(12));
        card.add(val); card.add(Box.createVerticalStrut(4));
        card.add(lbl);
        return card;
    }

    private JPanel buildQuickCard(String icon, String title, String desc, Color accent) {
        JPanel card = new JPanel();
        card.setBackground(BG_CARD);
        card.setBorder(BorderFactory.createCompoundBorder(
            new RoundedBorder(12, BORDER_COLOR),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JLabel ico = new JLabel(icon + "  " + title);
        ico.setFont(FONT_HEADER);
        ico.setForeground(accent);
        ico.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel dsc = new JLabel("<html><body style='width:160px'>" + desc + "</body></html>");
        dsc.setFont(FONT_SMALL); dsc.setForeground(TEXT_MUTED);
        dsc.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(ico); card.add(Box.createVerticalStrut(10));
        card.add(dsc);

        card.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { card.setBackground(BG_HOVER); }
            public void mouseExited(MouseEvent e)  { card.setBackground(BG_CARD);  }
        });
        return card;
    }

    private JPanel buildAddAnimalPage() {
        JPanel page = darkPage();
        page.setLayout(new BorderLayout(20, 20));
        page.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        page.add(pageHeader("🐾 Yeni Hayvan Kaydı", "Kliniğe yeni bir hasta ekleyin"), BorderLayout.NORTH);

        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(BG_CARD);
        card.setBorder(BorderFactory.createCompoundBorder(
            new RoundedBorder(12, BORDER_COLOR),
            BorderFactory.createEmptyBorder(28, 32, 28, 32)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        String[] turler = {"Köpek", "Kedi", "Kuş", "Balık", "At"};
        JComboBox<String> turBox = styledCombo(turler);
        JTextField nameField  = styledField("Hayvanın adı");
        JTextField breedField = styledField("Irk/Cins");
        JTextField ageField   = styledField("Yaş");
        JTextField weightField= styledField("Kilo (kg)");
        JTextField heightField= styledField("Boy (cm)");

        JPanel extraPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        extraPanel.setBackground(BG_CARD);
        JCheckBox check1 = styledCheckbox("Özellik 1");
        JCheckBox check2 = styledCheckbox("Özellik 2");
        JTextField extraField1 = styledField("—");
        JTextField extraField2 = styledField("—");
        extraPanel.add(check1); extraPanel.add(check2);
        extraPanel.add(extraField1); extraPanel.add(extraField2);

        turBox.addActionListener(e -> {
            int idx = turBox.getSelectedIndex();
            switch (idx) {
                case 0: check1.setText("Eğitimli mi?"); check2.setVisible(false); extraField1.setVisible(false); extraField2.setVisible(false); break;
                case 1: check1.setText("Ev kedisi mi?"); check2.setText("Kısırlaştırıldı mı?"); check2.setVisible(true); extraField1.setVisible(false); extraField2.setVisible(false); break;
                case 2: check1.setText("Uçabiliyor mu?"); check2.setVisible(false); extraField1.setVisible(true); extraField2.setVisible(true); break;
                case 3: check1.setVisible(false); check2.setVisible(false); extraField1.setVisible(true); extraField2.setVisible(true); break;
                case 4: check1.setText("Yarış atı mı?"); check2.setVisible(false); extraField1.setVisible(false); extraField2.setVisible(false); break;
            }
            extraPanel.revalidate(); extraPanel.repaint();
        });
        turBox.setSelectedIndex(0);

        int row = 0;
        addFormRow(card, gbc, row++, "Hayvan Türü", turBox);
        addFormRow(card, gbc, row++, "Ad",           nameField);
        addFormRow(card, gbc, row++, "Irk",          breedField);
        addFormRow(card, gbc, row++, "Yaş",          ageField);
        addFormRow(card, gbc, row++, "Kilo (kg)",    weightField);
        addFormRow(card, gbc, row++, "Boy (cm)",     heightField);
        addFormRow(card, gbc, row++, "Özellikler",   extraPanel);

        JButton saveBtn = accentButton("✓ Hayvanı Kaydet", ACCENT_TEAL);
        gbc.gridx=0; gbc.gridy=row; gbc.gridwidth=2; gbc.fill=GridBagConstraints.NONE;
        gbc.insets = new Insets(20, 8, 8, 8);
        card.add(saveBtn, gbc);

        saveBtn.addActionListener(e -> {
            try {
                String name = nameField.getText().trim();
                String breed = breedField.getText().trim();
                if (name.isEmpty() || breed.isEmpty()) throw new Exception("Ad ve ırk boş olamaz!");
                int ageVal = Integer.parseInt(ageField.getText().trim());
                double wt = Double.parseDouble(weightField.getText().trim());
                double ht = Double.parseDouble(heightField.getText().trim());
                
                // Buraya Animal sınıflarının nesne oluşturma mantığı gelecek
                showSuccess("✅ " + name + " başarıyla kaydedildi! (Diziye ekleme mantığı sınıflarınıza göre güncellenmelidir)");
                nameField.setText(""); breedField.setText(""); ageField.setText("");
                weightField.setText(""); heightField.setText("");
            } catch (Exception ex) {
                showError("Hata: " + ex.getMessage());
            }
        });

        JScrollPane scroll = new JScrollPane(card);
        scroll.setBorder(null); scroll.getViewport().setBackground(BG_DARK);
        page.add(scroll, BorderLayout.CENTER);
        return page;
    }

    private JPanel buildAnimalListPage() {
        JPanel page = darkPage();
        page.setLayout(new BorderLayout(20, 20));
        page.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        page.add(pageHeader("📋 Kayıtlı Hayvanlar", "Sistemdeki tüm hasta kayıtları"), BorderLayout.NORTH);

        String[] cols = {"Ad", "Tür", "Irk", "Yaş", "Kilo(kg)", "Boy(cm)", "Sahibi"};
        animalTableModel = new DefaultTableModel(cols, 0) { public boolean isCellEditable(int r, int c) { return false; } };
        JTable table = buildDarkTable(animalTableModel);

        JScrollPane scroll = new JScrollPane(table);
        styleScrollPane(scroll);
        page.add(scroll, BorderLayout.CENTER);

        JButton refresh = accentButton("⟳ Listeyi Yenile", ACCENT_BLUE);
        JPanel btnRow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnRow.setBackground(BG_DARK); btnRow.add(refresh);
        page.add(btnRow, BorderLayout.SOUTH);
        return page;
    }

    private JPanel buildAppointmentPage() {
        JPanel page = darkPage();
        page.setLayout(new BorderLayout(20, 20));
        page.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        page.add(pageHeader("📅 Randevu Oluştur", "Veteriner seçerek randevu alın"), BorderLayout.NORTH);

        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(BG_CARD);
        card.setBorder(BorderFactory.createCompoundBorder(new RoundedBorder(12, BORDER_COLOR), BorderFactory.createEmptyBorder(28, 32, 28, 32)));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8); gbc.anchor = GridBagConstraints.WEST;

        String[] vetNames = new String[vets.length];
        for (int i = 0; i < vets.length; i++) vetNames[i] = vets[i].getName() + " (" + vets[i].getSpecialization() + ")";
        
        JComboBox<String> vetBox = styledCombo(vetNames);
        JComboBox<String> animalBox = styledCombo(new String[]{"— Hayvan Seçin —"});
        JTextField dateField = styledField("Örn: 20.05.2026");
        JTextField timeField = styledField("Örn: 14:30");
        JTextArea descArea = new JTextArea(3, 20);
        descArea.setBackground(BG_DARK); descArea.setForeground(TEXT_PRIMARY);
        descArea.setBorder(BorderFactory.createCompoundBorder(new RoundedBorder(8, BORDER_COLOR), BorderFactory.createEmptyBorder(8, 12, 8, 12)));

        int row = 0;
        addFormRow(card, gbc, row++, "Veteriner Seçin", vetBox);
        addFormRow(card, gbc, row++, "Hasta (Hayvan)",  animalBox);
        addFormRow(card, gbc, row++, "Tarih",            dateField);
        addFormRow(card, gbc, row++, "Saat",            timeField);
        addFormRow(card, gbc, row++, "Açıklama",        descArea);

        JButton btn = accentButton("📅 Randevu Oluştur", ACCENT_PURPLE);
        gbc.gridx=0; gbc.gridy=row; gbc.gridwidth=2; gbc.insets = new Insets(20,8,8,8);
        card.add(btn, gbc);

        JScrollPane scroll = new JScrollPane(card);
        scroll.setBorder(null); scroll.getViewport().setBackground(BG_DARK);
        page.add(scroll, BorderLayout.CENTER);
        return page;
    }

    private JPanel buildMedicalPage() {
        JPanel page = darkPage();
        page.setLayout(new BorderLayout(20, 20));
        page.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        page.add(pageHeader("💉 Tıbbi Kayıt & Aşı Takibi", "Hasta tıbbi kayıtlarını yönetin"), BorderLayout.NORTH);

        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(BG_CARD);
        card.setBorder(BorderFactory.createCompoundBorder(new RoundedBorder(12, BORDER_COLOR), BorderFactory.createEmptyBorder(28, 32, 28, 32)));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8); gbc.anchor = GridBagConstraints.WEST;

        JComboBox<String> animalBox = styledCombo(new String[]{"— Hayvan seçin —"});
        JTextField dateField     = styledField("Tarih (10.05.2026)");
        JTextField diagField     = styledField("Tanı");
        JTextField treatField    = styledField("Tedavi");
        JTextField vaccineField  = styledField("Aşı adı (Örn: Kuduz)");

        int row = 0;
        addFormRow(card, gbc, row++, "Hasta (Hayvan)",     animalBox);
        addFormRow(card, gbc, row++, "Tarih",              dateField);
        addFormRow(card, gbc, row++, "Tanı",               diagField);
        addFormRow(card, gbc, row++, "Tedavi",             treatField);
        addFormRow(card, gbc, row++, "Aşı Bilgisi",        vaccineField);

        JButton btn = accentButton("💾 Kaydı Oluştur", ACCENT_ORANGE);
        gbc.gridx=0; gbc.gridy=row; gbc.gridwidth=2; gbc.insets=new Insets(20,8,8,8);
        card.add(btn, gbc);

        JScrollPane scroll = new JScrollPane(card);
        scroll.setBorder(null); scroll.getViewport().setBackground(BG_DARK);
        page.add(scroll, BorderLayout.CENTER);
        return page;
    }

    private JPanel buildAdoptionPage() {
        JPanel page = darkPage();
        page.setLayout(new BorderLayout(20, 20));
        page.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        page.add(pageHeader("🎯 Kişisel Sahiplendirme Testi", "Sana en uygun hayvanı bulalım"), BorderLayout.NORTH);

        JPanel quizCard = new JPanel(new BorderLayout(0, 20));
        quizCard.setBackground(BG_CARD);
        quizCard.setBorder(BorderFactory.createCompoundBorder(new RoundedBorder(12, BORDER_COLOR), BorderFactory.createEmptyBorder(28, 32, 28, 32)));

        JLabel qText = new JLabel("Hoşgeldiniz! Sahiplendirme testi yakında burada olacak.");
        qText.setFont(FONT_HEADER); qText.setForeground(TEXT_PRIMARY);
        quizCard.add(qText, BorderLayout.CENTER);

        page.add(quizCard, BorderLayout.NORTH);
        return page;
    }

    private JPanel buildVetsPage() {
        JPanel page = darkPage();
        page.setLayout(new BorderLayout(20, 20));
        page.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        page.add(pageHeader("👨‍⚕️ Veteriner Hekimler", "Klinikteki tüm doktorlar"), BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(1, vets.length, 16, 0));
        grid.setBackground(BG_DARK);
        Color[] colors = {ACCENT_TEAL, ACCENT_BLUE, ACCENT_PURPLE};

        for (int i = 0; i < vets.length; i++) {
            Veterinarian v = vets[i];
            JPanel card = new JPanel();
            card.setBackground(BG_CARD);
            card.setBorder(BorderFactory.createCompoundBorder(new RoundedBorder(12, BORDER_COLOR), BorderFactory.createEmptyBorder(24, 20, 24, 20)));
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

            JLabel name = new JLabel(v.getName());
            name.setFont(FONT_HEADER); name.setForeground(colors[i]);
            name.setAlignmentX(Component.CENTER_ALIGNMENT);
            JLabel spec = new JLabel(v.getSpecialization());
            spec.setFont(FONT_SMALL); spec.setForeground(TEXT_MUTED);
            spec.setAlignmentX(Component.CENTER_ALIGNMENT);

            card.add(name); card.add(Box.createVerticalStrut(4));
            card.add(spec); grid.add(card);
        }
        page.add(grid, BorderLayout.CENTER);
        return page;
    }

    // ── Yardımcı Metodlar ──────────────────────────────────────────
    private JPanel darkPage() { JPanel p = new JPanel(); p.setBackground(BG_DARK); return p; }
    private JPanel pageHeader(String title, String subtitle) {
        JPanel h = new JPanel(); h.setBackground(BG_DARK); h.setLayout(new BoxLayout(h, BoxLayout.Y_AXIS));
        JLabel t = new JLabel(title); t.setFont(FONT_TITLE); t.setForeground(TEXT_PRIMARY);
        JLabel s = new JLabel(subtitle); s.setFont(FONT_BODY); s.setForeground(TEXT_MUTED);
        h.add(t); h.add(Box.createVerticalStrut(4)); h.add(s); h.add(Box.createVerticalStrut(20));
        return h;
    }
    private void addFormRow(JPanel panel, GridBagConstraints gbc, int row, String label, JComponent field) {
        gbc.gridx = 0; gbc.gridy = row; gbc.gridwidth = 1; gbc.fill = GridBagConstraints.NONE;
        JLabel lbl = new JLabel(label); lbl.setFont(FONT_SMALL); lbl.setForeground(TEXT_MUTED); lbl.setPreferredSize(new Dimension(140, 26));
        panel.add(lbl, gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        field.setPreferredSize(new Dimension(320, field instanceof JTextArea ? 70 : 36));
        panel.add(field, gbc); gbc.weightx = 0;
    }
    private JTextField styledField(String hint) {
        JTextField f = new JTextField(); f.setBackground(BG_DARK); f.setForeground(TEXT_PRIMARY); f.setFont(FONT_BODY); f.setCaretColor(ACCENT_TEAL);
        f.setBorder(BorderFactory.createCompoundBorder(new RoundedBorder(8, BORDER_COLOR), BorderFactory.createEmptyBorder(6, 12, 6, 12)));
        return f;
    }
    private JComboBox<String> styledCombo(String[] items) {
        JComboBox<String> c = new JComboBox<>(items); c.setBackground(BG_DARK); c.setForeground(TEXT_PRIMARY);
        c.setBorder(new RoundedBorder(8, BORDER_COLOR)); return c;
    }
    private JCheckBox styledCheckbox(String text) {
        JCheckBox cb = new JCheckBox(text); cb.setBackground(BG_CARD); cb.setForeground(TEXT_PRIMARY); cb.setFocusPainted(false); return cb;
    }
    private JButton accentButton(String text, Color color) {
        JButton btn = new JButton(text) {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create(); g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getModel().isPressed() ? color.darker() : getModel().isRollover() ? color.brighter() : color);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10); g2.dispose(); super.paintComponent(g);
            }
        };
        btn.setForeground(Color.WHITE); btn.setFont(new Font("Segoe UI", Font.BOLD, 14)); btn.setBorderPainted(false);
        btn.setContentAreaFilled(false); btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(200, 42)); return btn;
    }
    private JTable buildDarkTable(DefaultTableModel model) {
        JTable table = new JTable(model); table.setBackground(BG_CARD); table.setForeground(TEXT_PRIMARY); table.setRowHeight(38);
        table.setSelectionBackground(new Color(ACCENT_TEAL.getRed(), ACCENT_TEAL.getGreen(), ACCENT_TEAL.getBlue(), 50));
        table.getTableHeader().setBackground(BG_DARK); table.getTableHeader().setForeground(TEXT_MUTED); return table;
    }
    private void styleScrollPane(JScrollPane sp) { sp.setBorder(new RoundedBorder(12, BORDER_COLOR)); sp.getViewport().setBackground(BG_CARD); }
    private JSeparator makeSeparator() { JSeparator sep = new JSeparator(); sep.setForeground(BORDER_COLOR); sep.setMaximumSize(new Dimension(220, 1)); return sep; }
    private void showSuccess(String msg) { JOptionPane.showMessageDialog(this, msg, "✅ Başarılı", JOptionPane.INFORMATION_MESSAGE); }
    private void showError(String msg) { JOptionPane.showMessageDialog(this, msg, "❌ Hata", JOptionPane.ERROR_MESSAGE); }

    static class RoundedBorder implements Border {
        private int radius; private Color color;
        RoundedBorder(int radius, Color color) { this.radius = radius; this.color = color; }
        public Insets getBorderInsets(Component c) { return new Insets(radius/2, radius/2, radius/2, radius/2); }
        public boolean isBorderOpaque() { return false; }
        public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
            Graphics2D g2 = (Graphics2D) g.create(); g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color); g2.drawRoundRect(x, y, w-1, h-1, radius, radius); g2.dispose();
        }
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}
        SwingUtilities.invokeLater(GUI::new);
    }
}
