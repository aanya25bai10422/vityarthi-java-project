import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Main {

    static Library library = new Library();

    // Colors
    static final Color BACKGROUND = new Color(250, 246, 250);
    static final Color PINK = new Color(224, 145, 170);
    static final Color DARK_PINK = new Color(190, 105, 135);
    static final Color LAVENDER = new Color(164, 145, 190);
    static final Color GREEN = new Color(139, 181, 151);
    static final Color PEACH = new Color(226, 169, 125);
    static final Color RED = new Color(205, 120, 125);
    static final Color TEXT = new Color(70, 65, 75);
    static final Color WHITE = Color.WHITE;

    static JFrame frame;
    static DefaultTableModel tableModel;
    static JTable table;

    static JLabel totalTitlesLabel;
    static JLabel totalCopiesLabel;
    static JLabel availableCopiesLabel;
    static JLabel issuedCopiesLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createWindow());
    }

    public static void createWindow() {

        frame = new JFrame("Library Manager");
        frame.setSize(1100, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(BACKGROUND);

        // ---------------- HEADER ----------------

        JPanel header = new JPanel();
        header.setBackground(BACKGROUND);
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBorder(
                BorderFactory.createEmptyBorder(25, 30, 15, 30)
        );

        JLabel title = new JLabel("LIBRARY MANAGER");
        title.setFont(
                new Font("SansSerif", Font.BOLD, 30)
        );
        title.setForeground(DARK_PINK);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel(
                "MAKE YOUR LIBRARY HUSTLE FREE"
        );
        subtitle.setFont(
                new Font("SansSerif", Font.PLAIN, 13)
        );
        subtitle.setForeground(TEXT);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        header.add(title);
        header.add(Box.createVerticalStrut(5));
        header.add(subtitle);

        frame.add(header, BorderLayout.NORTH);

        // ---------------- DASHBOARD ----------------

        JPanel dashboard = new JPanel(
                new GridLayout(1, 4, 15, 0)
        );

        dashboard.setBackground(BACKGROUND);
        dashboard.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 30, 20, 30
                )
        );

        totalTitlesLabel = new JLabel(
                "0",
                SwingConstants.CENTER
        );

        totalCopiesLabel = new JLabel(
                "0",
                SwingConstants.CENTER
        );

        availableCopiesLabel = new JLabel(
                "0",
                SwingConstants.CENTER
        );

        issuedCopiesLabel = new JLabel(
                "0",
                SwingConstants.CENTER
        );

        dashboard.add(
                createCard(
                        "BOOK TITLES",
                        totalTitlesLabel,
                        PINK
                )
        );

        dashboard.add(
                createCard(
                        "TOTAL COPIES",
                        totalCopiesLabel,
                        LAVENDER
                )
        );

        dashboard.add(
                createCard(
                        "AVAILABLE",
                        availableCopiesLabel,
                        GREEN
                )
        );

        dashboard.add(
                createCard(
                        "ISSUED",
                        issuedCopiesLabel,
                        PEACH
                )
        );

        // ---------------- CENTER PANEL ----------------

        JPanel centerPanel = new JPanel(
                new BorderLayout()
        );

        centerPanel.setBackground(BACKGROUND);

        String[] columns = {
                "ID",
                "TITLE",
                "AUTHOR",
                "CATEGORY",
                "TOTAL",
                "AVAILABLE",
                "ISSUED"
        };

        tableModel = new DefaultTableModel(
                columns,
                0
        ) {

            @Override
            public boolean isCellEditable(
                    int row,
                    int column) {

                return false;
            }
        };

        table = new JTable(tableModel);

        table.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        14
                )
        );

        table.setRowHeight(35);
        table.setBackground(WHITE);
        table.setForeground(TEXT);

        table.setGridColor(
                new Color(235, 225, 235)
        );

        table.setSelectionBackground(
                new Color(240, 210, 220)
        );

        table.setSelectionForeground(TEXT);

        table.getTableHeader().setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        13
                )
        );

        table.getTableHeader().setBackground(
                new Color(238, 220, 232)
        );

        table.getTableHeader().setForeground(TEXT);

        table.getTableHeader().setPreferredSize(
                new Dimension(0, 40)
        );

        // Center numeric columns

        DefaultTableCellRenderer centerRenderer =
                new DefaultTableCellRenderer();

        centerRenderer.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        table.getColumnModel()
                .getColumn(0)
                .setCellRenderer(centerRenderer);

        table.getColumnModel()
                .getColumn(4)
                .setCellRenderer(centerRenderer);

        table.getColumnModel()
                .getColumn(5)
                .setCellRenderer(centerRenderer);

        table.getColumnModel()
                .getColumn(6)
                .setCellRenderer(centerRenderer);

        JScrollPane scrollPane =
                new JScrollPane(table);

        scrollPane.setBorder(
                BorderFactory.createEmptyBorder(
                        0, 30, 10, 30
                )
        );

        centerPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        // ---------------- BUTTON PANEL ----------------

        JPanel buttonPanel = new JPanel(
                new GridLayout(1, 6, 12, 0)
        );

        buttonPanel.setBackground(BACKGROUND);

        buttonPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 30, 25, 30
                )
        );

        RoundedButton addButton =
                new RoundedButton(
                        "Add Book",
                        PINK,
                        DARK_PINK
                );

        RoundedButton searchButton =
                new RoundedButton(
                        "Search",
                        LAVENDER,
                        new Color(135, 115, 165)
                );

        RoundedButton issueButton =
                new RoundedButton(
                        "Issue Book",
                        GREEN,
                        new Color(110, 155, 125)
                );

        RoundedButton returnButton =
                new RoundedButton(
                        "Return Book",
                        PEACH,
                        new Color(205, 145, 100)
                );

        RoundedButton removeButton =
                new RoundedButton(
                        "Remove",
                        RED,
                        new Color(185, 95, 105)
                );

        RoundedButton refreshButton =
                new RoundedButton(
                        "Refresh",
                        DARK_PINK,
                        new Color(165, 85, 115)
                );

        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(issueButton);
        buttonPanel.add(returnButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(refreshButton);

        centerPanel.add(
                buttonPanel,
                BorderLayout.SOUTH
        );

        // ---------------- MAIN CONTENT ----------------

        JPanel mainContent = new JPanel(
                new BorderLayout()
        );

        mainContent.setBackground(BACKGROUND);

        mainContent.add(
                dashboard,
                BorderLayout.NORTH
        );

        mainContent.add(
                centerPanel,
                BorderLayout.CENTER
        );

        frame.add(
                mainContent,
                BorderLayout.CENTER
        );

        // ---------------- BUTTON ACTIONS ----------------

        addButton.addActionListener(
                e -> addBook()
        );

        searchButton.addActionListener(
                e -> searchBook()
        );

        issueButton.addActionListener(
                e -> issueBook()
        );

        returnButton.addActionListener(
                e -> returnBook()
        );

        removeButton.addActionListener(
                e -> removeBook()
        );

        refreshButton.addActionListener(
                e -> refreshTable()
        );

        refreshTable();

        frame.setVisible(true);
    }

    // ---------------- CARD ----------------

    public static JPanel createCard(
            String title,
            JLabel valueLabel,
            Color color) {

        JPanel card = new JPanel(
                new BorderLayout()
        );

        card.setBackground(WHITE);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(235, 225, 235)
                        ),
                        BorderFactory.createEmptyBorder(
                                15, 10, 15, 10
                        )
                )
        );

        JLabel titleLabel = new JLabel(
                title,
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        12
                )
        );

        titleLabel.setForeground(TEXT);

        valueLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        26
                )
        );

        valueLabel.setForeground(color);

        card.add(
                titleLabel,
                BorderLayout.NORTH
        );

        card.add(
                valueLabel,
                BorderLayout.CENTER
        );

        return card;
    }

    // ---------------- ADD BOOK ----------------

    public static void addBook() {

        try {

            String idText =
                    JOptionPane.showInputDialog(
                            frame,
                            "Enter Book ID:"
                    );

            if (idText == null) {
                return;
            }

            int id = Integer.parseInt(idText);

            if (library.searchBook(id) != null) {

                JOptionPane.showMessageDialog(
                        frame,
                        "A book with this ID already exists."
                );

                return;
            }

            String title =
                    JOptionPane.showInputDialog(
                            frame,
                            "Enter Book Title:"
                    );

            if (title == null ||
                    title.trim().isEmpty()) {

                return;
            }

            String author =
                    JOptionPane.showInputDialog(
                            frame,
                            "Enter Author:"
                    );

            if (author == null ||
                    author.trim().isEmpty()) {

                return;
            }

            String category =
                    JOptionPane.showInputDialog(
                            frame,
                            "Enter Category:"
                    );

            if (category == null ||
                    category.trim().isEmpty()) {

                return;
            }

            String copiesText =
                    JOptionPane.showInputDialog(
                            frame,
                            "Enter Total Number of Copies:"
                    );

            if (copiesText == null) {
                return;
            }

            int totalCopies =
                    Integer.parseInt(copiesText);

            if (totalCopies <= 0) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Number of copies must be greater than 0."
                );

                return;
            }

            Book book = new Book(
                    id,
                    title,
                    author,
                    category,
                    totalCopies
            );

            library.addBook(book);

            refreshTable();

            JOptionPane.showMessageDialog(
                    frame,
                    "Book added successfully.\n"
                            + "Total copies: "
                            + totalCopies
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    frame,
                    "Please enter valid numbers for ID and copies."
            );
        }
    }

    // ---------------- SEARCH BOOK BY NAME ----------------

    public static void searchBook() {

        String title =
                JOptionPane.showInputDialog(
                        frame,
                        "Enter Book Name to search:"
                );

        if (title == null ||
                title.trim().isEmpty()) {

            return;
        }

        Book book = library.searchBook(title);

        if (book != null) {

            String message =
                    "Book ID: " + book.getId()
                            + "\nTitle: " + book.getTitle()
                            + "\nAuthor: " + book.getAuthor()
                            + "\nCategory: " + book.getCategory()
                            + "\nTotal Copies: "
                            + book.getTotalCopies()
                            + "\nAvailable Copies: "
                            + book.getAvailableCopies()
                            + "\nIssued Copies: "
                            + book.getIssuedCopies();

            JOptionPane.showMessageDialog(
                    frame,
                    message,
                    "Book Details",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else {

            JOptionPane.showMessageDialog(
                    frame,
                    "Book not found."
            );
        }
    }

    // ---------------- ISSUE BOOK BY NAME ----------------

    public static void issueBook() {

        String title =
                JOptionPane.showInputDialog(
                        frame,
                        "Enter Book Name to issue:"
                );

        if (title == null ||
                title.trim().isEmpty()) {

            return;
        }

        Book book = library.searchBook(title);

        if (book == null) {

            JOptionPane.showMessageDialog(
                    frame,
                    "Book not found."
            );

            return;
        }

        if (book.getAvailableCopies() == 0) {

            JOptionPane.showMessageDialog(
                    frame,
                    "No copies of this book are currently available."
            );

            return;
        }

        library.issueBook(title);

        refreshTable();

        JOptionPane.showMessageDialog(
                frame,
                "Book issued successfully.\n"
                        + "Available copies: "
                        + book.getAvailableCopies()
        );
    }

    // ---------------- RETURN BOOK BY NAME ----------------

    public static void returnBook() {

        String title =
                JOptionPane.showInputDialog(
                        frame,
                        "Enter Book Name to return:"
                );

        if (title == null ||
                title.trim().isEmpty()) {

            return;
        }

        Book book = library.searchBook(title);

        if (book == null) {

            JOptionPane.showMessageDialog(
                    frame,
                    "Book not found."
            );

            return;
        }

        if (book.getIssuedCopies() == 0) {

            JOptionPane.showMessageDialog(
                    frame,
                    "All copies of this book are already available."
            );

            return;
        }

        library.returnBook(title);

        refreshTable();

        JOptionPane.showMessageDialog(
                frame,
                "Book returned successfully.\n"
                        + "Available copies: "
                        + book.getAvailableCopies()
        );
    }

    // ---------------- REMOVE BOOK BY NAME ----------------

    public static void removeBook() {

        String title =
                JOptionPane.showInputDialog(
                        frame,
                        "Enter Book Name to remove:"
                );

        if (title == null ||
                title.trim().isEmpty()) {

            return;
        }

        Book book = library.searchBook(title);

        if (book == null) {

            JOptionPane.showMessageDialog(
                    frame,
                    "Book not found."
            );

            return;
        }

        if (book.getIssuedCopies() > 0) {

            JOptionPane.showMessageDialog(
                    frame,
                    "This book cannot be removed because "
                            + book.getIssuedCopies()
                            + " copy/copies are currently issued."
            );

            return;
        }

        int choice =
                JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to remove \""
                                + book.getTitle()
                                + "\"?",
                        "Confirm Remove",
                        JOptionPane.YES_NO_OPTION
                );

        if (choice == JOptionPane.YES_OPTION) {

            library.removeBook(title);

            refreshTable();

            JOptionPane.showMessageDialog(
                    frame,
                    "Book removed successfully."
            );
        }
    }

    // ---------------- REFRESH TABLE ----------------

    public static void refreshTable() {

        tableModel.setRowCount(0);

        int totalTitles = 0;
        int totalCopies = 0;
        int availableCopies = 0;
        int issuedCopies = 0;

        for (Book book : library.getBooks()) {

            tableModel.addRow(
                    new Object[]{
                            book.getId(),
                            book.getTitle(),
                            book.getAuthor(),
                            book.getCategory(),
                            book.getTotalCopies(),
                            book.getAvailableCopies(),
                            book.getIssuedCopies()
                    }
            );

            totalTitles++;

            totalCopies +=
                    book.getTotalCopies();

            availableCopies +=
                    book.getAvailableCopies();

            issuedCopies +=
                    book.getIssuedCopies();
        }

        totalTitlesLabel.setText(
                String.valueOf(totalTitles)
        );

        totalCopiesLabel.setText(
                String.valueOf(totalCopies)
        );

        availableCopiesLabel.setText(
                String.valueOf(availableCopies)
        );

        issuedCopiesLabel.setText(
                String.valueOf(issuedCopies)
        );
    }
}


