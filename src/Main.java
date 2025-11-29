public class Main {

    static int attempts = 0;

    public static void main(String[] args) {

        // 1ª Parte - Validador (Validator)

        for (int i = 1; i <= 3; i++) {
            Integer[][][] solvedMatrix = SudokuSource.getSolvedMatrix(i);

            if (Validator.validateSudoku(solvedMatrix)) {
                System.out.println("Matrix " + i + " is valid");
            } else {
                System.out.println("Matrix " + i + " is not valid");
            }
            System.out.println();
        }

        // 2ª Parte - Solucionador (Solver)
        for (int i = 1; i <= 3; i++) {
            attempts = 0; // Reseta o contador para cada sudoku
            Integer[][][] sudoku = SudokuSource.getUnsolvedMatrix(i);
            
            System.out.println("Resolvendo Sudoku #" + i + "...");

            if (resolver(sudoku, 0, 0, 0)) {
                System.out.println("Tentativas: " + attempts);

                if (Validator.validateSudoku(sudoku)) {
                    System.out.println("Solucao valida!");

                    for (int linGlobal = 0; linGlobal < 9; linGlobal++) {
                        for (int colGlobal = 0; colGlobal < 9; colGlobal++) {
                            int blocoIndex = (linGlobal / 3) * 3 + (colGlobal / 3);
                            int linhaBloco = linGlobal % 3;
                            int colunaBloco = colGlobal % 3;
                            System.out.print(sudoku[blocoIndex][linhaBloco][colunaBloco] + " ");
                            if (colGlobal % 3 == 2) System.out.print("  ");
                        }
                        System.out.println();
                        if (linGlobal % 3 == 2) System.out.println();
                    }
                }
            } else {
                System.out.println("Nao conseguiu resolver");
            }
        }
    }

    public static boolean resolver(Integer[][][] matrix, int block, int line, int column) {
        attempts++;

        if (block == 9) {
            return true;
        }

        // Calcula a proxima posicao (bloco, linha, coluna)
        int nextBlock = block;
        int nextLine = line;
        int nextColumn = column + 1;

        // Se passou da coluna 2 volta pra coluna 0 e vai pra proxima linha
        if (nextColumn == 3) {
            nextColumn = 0;
            nextLine++;
        }

        // Se passou da linha 2, volta pra linha 0 e vai pro proximo bloco
        if (nextLine == 3) {
            nextLine = 0;
            nextBlock++;
        }

        if (matrix[block][line][column] != null) {
            return resolver(matrix, nextBlock, nextLine, nextColumn);
        }

        // Tenta colocar numeros de 1 a 9
        for (int num = 1; num <= 9; num++) {

            matrix[block][line][column] = num;

            // Verifica se esse numero eh valido (nao repete na linha, coluna ou bloco)
            if (isValid(matrix, block, line, column)) {

                if (resolver(matrix, nextBlock, nextLine, nextColumn)) {
                    return true;
                }
            }
        }

        // Se chegou aqui, significa que tentou todos os numeros de 1 a 9
        // e nenhum funcionou, entao retorna false
        matrix[block][line][column] = null;
        return false;
    }

    // funcao que verifica se o numero colocado na posicao é valido
    public static boolean isValid(Integer[][][] matrix, int block, int line, int column) {
        Integer num = matrix[block][line][column];

        // Verifica o bloco
        // quantidade de vezes que o numero aparece no bloco
        int count = 0;
        for (int linBlock = 0; linBlock < 3; linBlock++) {
            for (int colBlock = 0; colBlock < 3; colBlock++) {
                if (matrix[block][linBlock][colBlock] != null && matrix[block][linBlock][colBlock].equals(num)) {
                    count++;

                    if (count > 1) {
                        return false;
                    }
                }
            }
        }

        // Verifica a linha completa
        int lineGlobal = (block / 3) * 3 + line;

        count = 0;

        for (int col = 0; col < 9; col++) {
            int blockIndex = (lineGlobal / 3) * 3 + (col / 3);

            // Calcula qual linha dentro do bloco
            int lineBlock = lineGlobal % 3;

            // Calcula a coluna dentro do bloco
            int columnBlock = col % 3;

            Integer value = matrix[blockIndex][lineBlock][columnBlock];

            if (value != null && value.equals(num)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }

        // Verifica a coluna completa
        int columnGlobal = (block % 3) * 3 + column;

        count = 0;

        for (int lin = 0; lin < 9; lin++) {
            int blockIndex = (lin / 3) * 3 + (columnGlobal / 3);

            // Calcula qual linha dentro do bloco
            int lineBlock = lin % 3;

            // Calcula a coluna dentro do bloco
            int columnBlock = columnGlobal % 3;

            Integer value = matrix[blockIndex][lineBlock][columnBlock];

            if (value != null && value.equals(num)) {
                count++;

                if (count > 1) {
                    return false;
                }
            }
        }

        return true;
    }

}
