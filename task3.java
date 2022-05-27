public class task3 {
    public static void main(String[] args) throws IOException{

        int baseSystem, targetSystem, numFromDecSystem;
        String numToDecSystem, n1, n2, choose;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("");
            System.out.println("------------------------");
            System.out.println("Choose what operation you want to perform:");
            System.out.println("");
            System.out.println("A. Convert from any system to the decimal system");
            System.out.println("B. Convert from decimal system to another system");
            System.out.println("C. Summing up numbers from different systems");
            System.out.println("D. Subtracting numbers from different systems");
            System.out.println("E. Multiplying numbers from different systems");
            System.out.println("F. Dividing numbers from different systems");
            System.out.println("");
            System.out.println("W. Exit the program");

            choose = br.readLine();

            if(choose.equals("A")){
                System.out.println("Enter the value you wish to covert to decimal system:");
                numToDecSystem = br.readLine();

                System.out.println("What system is this value from?");
                baseSystem = Integer.parseInt(br.readLine());

                System.out.println(convertToDecimal(numToDecSystem, fromWhatSystem(baseSystem)));

            }else if(choose.equals("B")){
                System.out.println("Enter a decimal value:");
                numFromDecSystem = Integer.parseInt(br.readLine());

                System.out.println("To what system do you wish to convert it to?");
                targetSystem = Integer.parseInt(br.readLine());

                String result2 = convertFromDecimal(onWhatSystem(targetSystem), numFromDecSystem);
                System.out.println(result2);

            }else if (choose.equals("C")){
                System.out.println("Enter the first number to sum: ");
                n1 = br.readLine();
                System.out.println("What system is it from?");
                baseSystem = Integer.parseInt(br.readLine());
                int syntaxSum1 = convertToDecimal(n1,fromWhatSystem(baseSystem));

                System.out.println("Enter the second number to sum: ");
                n2 = br.readLine();
                System.out.println("What system is it from?");
                baseSystem = Integer.parseInt(br.readLine());
                int syntaxSum2 = convertToDecimal(n2,fromWhatSystem(baseSystem));

                System.out.println("In which system should the result be displayed?");
                targetSystem = Integer.parseInt(br.readLine());
                System.out.println("The result of this addition is: " + convertFromDecimal(onWhatSystem(targetSystem), syntaxSum1 + syntaxSum2) + " in the system " + targetSystem);

            }else if (choose.equals("D")){
                System.out.println("Enter the first number to be subtracted:");
                n1 = br.readLine();
                System.out.println("What system is it from?");
                baseSystem = Integer.parseInt(br.readLine());
                int diffComponent1 = convertToDecimal(n1,fromWhatSystem(baseSystem));

                System.out.println("Enter the second value to be subtracted:");
                n2 = br.readLine();
                System.out.println("What system is it from?");
                baseSystem = Integer.parseInt(br.readLine());
                int diffComponent2 = convertToDecimal(n2,fromWhatSystem(baseSystem));

                System.out.println("In which system should the result be displayed?");
                targetSystem = Integer.parseInt(br.readLine());
                System.out.println("The result of this difference is: " + convertFromDecimal(onWhatSystem(targetSystem), diffComponent1 - diffComponent2) + "in the system " + targetSystem);

            }else if (choose.equals("E")){
                System.out.println("Enter the first value to be multiplied:");
                n1 = br.readLine();
                System.out.println("What system is it from?");
                baseSystem = Integer.parseInt(br.readLine());
                int prodComponent1 = convertToDecimal(n1,fromWhatSystem(baseSystem));

                System.out.println("Enter the second value to be multiplied:");
                n2 = br.readLine();
                System.out.println("What system is it from?");
                baseSystem = Integer.parseInt(br.readLine());
                int prodComponent2 = convertToDecimal(n2,fromWhatSystem(baseSystem));

                System.out.println("In which system should the result be displayed?");
                targetSystem = Integer.parseInt(br.readLine());
                System.out.println("The result of this multiplication is: " + convertFromDecimal(onWhatSystem(targetSystem), prodComponent1 * prodComponent2) + " in the system " + targetSystem);

            }else if (choose.equals("F")){
                System.out.println("Enter the first value for the division:");
                n1 = br.readLine();
                System.out.println("What system is it from?");
                baseSystem = Integer.parseInt(br.readLine());
                int divComponent1 = convertToDecimal(n1,fromWhatSystem(baseSystem));

                System.out.println("Enter the second value for the division:");
                n2 = br.readLine();
                System.out.println("What system is it from?");
                baseSystem = Integer.parseInt(br.readLine());
                int divComponent2 = convertToDecimal(n2,fromWhatSystem(baseSystem));

                System.out.println("In which system should this result be displayed?");
                targetSystem = Integer.parseInt(br.readLine());
                System.out.println("The result of this division is: " + convertFromDecimal(onWhatSystem(targetSystem), divComponent1 / divComponent2) + " in the system " + targetSystem);

            }
        } while(!choose.equals("W"));
    }

    static int val(char c){
        if (c >= '0' && c < '9')
            return (int) c - '0';
        else
            return (int) c - 'A' + 10;
    }

    public static int convertToDecimal(String str, int baseSystem){
        int len = str.length();
        int power = 1;
        int num = 0;
        int i;

        for(i = len - 1; i>= 0; i--){
            if(val(str.charAt(i)) >= baseSystem){
                System.out.println("Wrong number");
                return -1;
            }

            num += val(str.charAt(i)) * power;
            power = power * baseSystem;
        }

        return num;
}
