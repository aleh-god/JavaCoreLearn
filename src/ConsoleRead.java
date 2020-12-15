
import java.io.*;

public class ConsoleRead {
    public static void main(String[] args) {

        // Здесь объект BufferedReader устанавливается для чтения с консоли с помощью объекта InputStreamReader(System.in)
        //Так как консоль это текст, то используем символьные потоки BufferedReader и BufferedWriter
        //An InputStreamReader is a bridge from byte streams to character streams: It reads bytes and decodes them into characters using a specified charset.
        try(BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new FileWriter("notesConsole.txt")))
        {
            //В цикле while считывается введенный текст. И пока пользователь не введет строку "ESC",
            String text;
            while(!(text=br.readLine()).equals("ESC")){

                // объект BufferedWriter будет записывать текст файл.
                bw.write(text + "\n");
                bw.flush();
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
