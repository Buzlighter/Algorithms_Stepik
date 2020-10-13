import java.util.*;


class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        Integer k = scanner.nextInt();
        Integer l = scanner.nextInt();
        HashMap<String, String> freqAndLetters = new HashMap<>();
        scanner.nextLine();
        for (int i = 0; i < k; i++) {
            String s = scanner.nextLine();
            String[] input = s.split(": ");
            freqAndLetters.put(input[1], input[0]);
        }
        String code = "";
        code = scanner.next();
        String subCode = "";
        StringBuilder letterCode = new StringBuilder();



        for (int i = 0; i < l; i++) {
            subCode += code.charAt(i);
            if (freqAndLetters.containsKey(subCode)) {
                letterCode.append(freqAndLetters.get(subCode));
                subCode = "";
            }
        }
        System.out.println(letterCode.toString());
    }
}