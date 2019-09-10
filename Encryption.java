import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {
        String myString = s.replaceAll("\\s", "");
        Double sqrt = Math.sqrt(myString.length());
        String[] arr = new String[(int) Math.ceil(sqrt)];
        StringBuilder encryptedString = new StringBuilder();
        if(Math.ceil(sqrt) >1) {
            int j =0;
            int l = 0;
            for(int i=0 ; i < myString.length(); i+= Math.ceil(sqrt)) {
                if(i+ (int) Math.ceil(sqrt)  < myString.length()) {
                    arr[j]  = myString.substring(i, i + (int) Math.ceil(sqrt));
                } else {
                    arr[j]  = myString.substring(i);
                }
                
                j++;
            }
            for (int k = 0; k < arr.length; k++) {
                if (arr[k] != null && arr[k].length() > l)
                    encryptedString.append(arr[k].charAt(l));

                if (k == arr.length - 1 && l != arr.length - 1) {
                    k = -1;
                    l++;
                    encryptedString.append(" ");
                }
            }
            encryptedString.toString();
        } else {
            encryptedString.append(myString);
        }
     return encryptedString.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
