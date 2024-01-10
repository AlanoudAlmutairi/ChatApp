import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class GUI implements ActionListener {
    JButton calcbutton;
    JButton notepadButton;
    JButton sendButton , sendButton2;
    private JTextArea chatArea, chatArea2;
    private JTextField messageField , messageField2;


    public GUI(User u1 , User u2) {


        JFrame frame = new JFrame();
        frame.setSize(700 , 600);
        frame.setResizable(true);
        //////////////////////////
        JPanel panel = new JPanel();
        //////////////////////////
        messageField = new JTextField();
        messageField2= new JTextField();
        //////////////////////////
        sendButton = new JButton("SEND1");
        sendButton2 = new JButton("SEND2");
        sendButton2.setBounds(500 , 355 , 100 ,30 );
        sendButton.setBounds(200 , 355 , 100 ,30 );

///////////////////////////////////////////////////////////////////////////////
        JLabel name = new JLabel(" USER 1 AREA ");
        name.setBounds(47 , 30 , 90 , 200);
///
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane panle1 = new JScrollPane(chatArea);
        panle1.setBounds(50 , 150 , 250 , 200);

        frame.add(name);
        frame.add(panle1);

///
        JLabel name2 = new JLabel("USER 2 AREA ");
        name2.setBounds(350 , 30 , 90, 200);

        chatArea2 = new JTextArea();
        chatArea2.setEditable(false);
        JScrollPane panle2 = new JScrollPane(chatArea2);
        panle2.setBounds(350 , 150 , 250 , 200);

        frame.add(name2);
        frame.add(panle2);
////////////////////////////////////////////////////////////
        messageField.setBounds(50, 355, 150 ,30 );
        messageField2.setBounds(350, 355, 150 ,30 );
        frame.add(messageField);
        frame.add(messageField2);
//////////////////////////////////////////////////////////////

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageField.getText();
                if (!message.isEmpty()) {
                    Channel msgQ = u1.getQueue();
                    u1.setMode("writer");
                    msgQ.send(message);
                    String msg = (String) msgQ.receive();
                    u1.setMode("reader");
                    chatArea2.append("user1: " + msg+ "\n");
                    messageField.setText("");
                }  } }  );

        frame.add(sendButton);



        sendButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message2 = messageField2.getText();
                if (!message2.isEmpty()) {
                    Channel msgQ = u2.getQueue();
                    u2.setMode("writer");
                    msgQ.send(message2);
                    String msg = (String) msgQ.receive();
                    u2.setMode("reader");
                    chatArea.append("user2: " + msg+ "\n");

                    messageField2.setText("");
                }

            }
        });


        frame.add(sendButton2);
        ////////////////////////////////////////////////////////////

        calcbutton = new JButton("calculatore");
        calcbutton.addActionListener(this);



        notepadButton  = new JButton("Notepad");
        notepadButton.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(10, 100, 50, 100));

        panel.add(calcbutton);
        panel.add(notepadButton);
        frame.add(panel);
        ////////////////////////////////////////////////////////
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Our computer");
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e ) {
        ProcessBuilder pb = null;
        if (e.getSource() ==calcbutton ){
            pb = new ProcessBuilder("calc.exe");

            try {
                execute(pb);
            } catch (IOException ex) {
                throw new RuntimeException(ex);}


        }
        else if (e.getSource() == notepadButton){
            pb= new ProcessBuilder("notepad.exe");

            try {
                execute(pb);
            } catch (IOException ex) {
                throw new RuntimeException(ex);}

        }


        }

    public void execute( ProcessBuilder pb) throws IOException {
        Process proc = pb.start();
        InputStream is = proc.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String line;

        while ((line = br.readLine())  != null)
            System.out.println(line);
    br.readLine();
    }




}


