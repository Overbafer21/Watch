import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Digital_clock extends JFrame {

    private JLabel timeLabel;
    private JLabel dateLabel;

    public Digital_clock() {
        setTitle("Цифровые часы");
        setSize(560, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel outerPanel = new JPanel(new BorderLayout());
        outerPanel.setBackground(new Color(10, 14, 23));
        outerPanel.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));

        JPanel clockCard = new JPanel(new GridLayout(2, 1, 0, 8));
        clockCard.setBackground(new Color(25, 32, 48));
        clockCard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(72, 84, 112), 1),
                BorderFactory.createEmptyBorder(24, 20, 18, 20)
        ));

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Consolas", Font.BOLD, 68));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setForeground(new Color(88, 214, 141));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setForeground(new Color(196, 207, 231));

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
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss", Locale.forLanguageTag("ru-RU"));
        String time = timeFormatter.format(calendar.getTime());

        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.forLanguageTag("ru-RU"));
        String date = dateFormatter.format(calendar.getTime());

        timeLabel.setText(time);
        dateLabel.setText(date.substring(0, 1).toUpperCase() + date.substring(1));
    }

    public static void main(String[] args) {
        Digital_clock clock = new Digital_clock();
        clock.setVisible(true);
    }
}
