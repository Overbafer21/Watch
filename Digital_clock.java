import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class Digital_clock extends JFrame {

    private static final Locale RU_LOCALE = Locale.forLanguageTag("ru-RU");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss", RU_LOCALE);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", RU_LOCALE);

    private JLabel timeLabel;
    private JLabel dateLabel;

    public Digital_clock() {
        setTitle("Цифровые часы");
        setSize(620, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel outerPanel = new JPanel(new BorderLayout());
        outerPanel.setBackground(new Color(10, 14, 23));
        outerPanel.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));

        JPanel clockCard = new JPanel(new GridLayout(3, 1, 0, 6));
        clockCard.setBackground(new Color(25, 32, 48));
        clockCard.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(72, 84, 112), 1, true),
                BorderFactory.createEmptyBorder(20, 20, 16, 20)
        ));

        JLabel titleLabel = new JLabel("WATCH", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(new Color(139, 154, 184));

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Consolas", Font.BOLD, 74));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setForeground(new Color(88, 214, 141));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setForeground(new Color(196, 207, 231));

        clockCard.add(titleLabel);
        clockCard.add(timeLabel);
        clockCard.add(dateLabel);
        outerPanel.add(clockCard, BorderLayout.CENTER);

        add(outerPanel);

        updateTimeAndDate();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTimeAndDate();
            }
        });
        timer.start();
    }

    private void updateTimeAndDate() {
        LocalDateTime now = LocalDateTime.now();
        String time = now.format(TIME_FORMATTER);
        String date = now.format(DATE_FORMATTER);

        timeLabel.setText(time);
        dateLabel.setText(Character.toUpperCase(date.charAt(0)) + date.substring(1));
    }

    public static void main(String[] args) {
        Digital_clock clock = new Digital_clock();
        clock.setVisible(true);
    }
}