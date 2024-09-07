// 323805861 Tamar Michelson
class Factorial {

    /**
     *  recursive function that calculates a factorial.
     * @param a list of integers
     * @return Factorial
     */
    static int recursiveFunction(int a) {
        if (a == 1) {
            return 1;
        }
        int b = recursiveFunction(a - 1);
        return (a * b);
    }

    /**
     * @param n list of integers
     * A iterative function that calculates a factorial
     * @return Factorial
     */
    static int iterativeFunction(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    //The Main function that calculates the factorial in two different ways
    public static void main(String[] args) {

        System.out.println("java Factorial");
        // System.out.println(args[0]);
        int n = Integer.parseInt(args[0]);
        //String conversion to int;
        int factorial1 = recursiveFunction(n);
        //call the recursive function;
        int factorial2 = iterativeFunction(n);
        //call the iterative function;
        System.out.println("recursive: " + factorial1);
        System.out.println("iterative: " + factorial2);
    }

}