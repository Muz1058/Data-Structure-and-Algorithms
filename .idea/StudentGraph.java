// import java.awt.*;
// import javax.swing.*;

// public class StudentGraph extends JPanel {

//     private final String[] subjects = {"Math", "Science", "History", "English"};
//     private final int[] students = {12, 18, 10, 15};
    
//     @Override
//     protected void paintComponent(Graphics g) {
//         super.paintComponent(g);
        
//         // Set background color
//         setBackground(Color.WHITE);
        
//         int width = getWidth();
//         int height = getHeight();
//         int barWidth = width / (subjects.length * 2);
//         int maxStudents = 20;  // Scale max height (adjust if needed)

//         // Draw axes
//         g.drawLine(50, height - 50, 50, 50);  // Y-axis
//         g.drawLine(50, height - 50, width - 50, height - 50);  // X-axis
        
//         // Draw bars
//         for (int i = 0; i < subjects.length; i++) {
//             int barHeight = (students[i] * (height - 100)) / maxStudents;
//             int x = 70 + i * 2 * barWidth;
//             int y = height - 50 - barHeight;

//             g.setColor(new Color(50 + i * 50, 100 + i * 30, 200 - i * 40));  // Colorful bars
//             g.fillRect(x, y, barWidth, barHeight);

//             g.setColor(Color.BLACK);
//             g.drawString(subjects[i], x + 5, height - 30);
//             g.drawString(String.valueOf(students[i]), x + 5, y - 5);
//         }
//     }

//     public static void main(String[] args) {
//         JFrame frame = new JFrame("Student Subject Graph");
//         StudentGraph panel = new StudentGraph();
//         frame.add(panel);
//         frame.setSize(500, 400);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setVisible(true);
//     }
// }

import java.util.Scanner;

public class StudentGraph {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        System.out.print("Enter The No Of Size Subject's Your Array : ");
        int size=input.nextInt();
        input.nextLine();
        String []sub=new String[size];
        int [] noStudent=new int[size];
        System.out.println("\nSubjects Input\n");
        for (int i=0;i<sub.length;i++)
        {
            System.out.print("Enter The Subject "+(i+1)+": ");
            sub[i]=input.nextLine();
            System.out.print("Enter The Number of Students for " + sub[i] + ": ");
            noStudent[i]=input.nextInt();
            input.nextLine();
        }

        System.out.println("\t\tPrint The Bar Graph.");
      for (int i=0;i<sub.length;i++)
      {
          System.out.print(sub[i]+"\t| ");
          for (int j=0;j<noStudent[i];j++)
          {
              System.out.print("*");
          }
          System.out.println();
      }

    }
}