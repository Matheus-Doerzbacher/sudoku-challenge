
public class Main {

    public static void main(String[] args) {

        System.out.println("Start Here");

        // Escolhe uma matriz solucionada para usar no VALIDADOR (VALIDATOR)
        for (int i = 1; i <= 3; i++) {
        Integer[][][] solvedMatrix = SudokuSource.getSolvedMatrix(i);
            System.out.println();
            if (Validator.validateSudoku(solvedMatrix)) {
                System.out.println("Matrix " + i + " is valid");
            } else {
                System.out.println("Matrix " + i + " is not valid");
            }
        }

    }

}
