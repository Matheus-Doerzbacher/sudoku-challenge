import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static boolean validateSudoku(Integer[][][] matrix) {

        List<Integer[][]> listBlocks = new ArrayList<>();
        List<List<Integer>> listLines = new ArrayList<>();
        List<List<Integer>> listColumns = new ArrayList<>();

        // Adiciona os blocos à lista
        for (Integer[][] block : matrix) {
            listBlocks.add(block);
        }

        // Adiciona as linhas à lista
        for (int i = 0; i < 3; i++) {
            Integer numberBlock = i * 3;
            listLines.add(getLine(listBlocks.get(numberBlock), listBlocks.get(numberBlock + 1),
                    listBlocks.get(numberBlock + 2), 1));
            listLines.add(getLine(listBlocks.get(numberBlock), listBlocks.get(numberBlock + 1),
                    listBlocks.get(numberBlock + 2), 2));
            listLines.add(getLine(listBlocks.get(numberBlock), listBlocks.get(numberBlock + 1),
                    listBlocks.get(numberBlock + 2), 3));
        }

        // Adiciona as colunas à lista
        for (int i = 0; i < 3; i++) {
            Integer numberBlock = i * 3;
            listColumns.add(getColumn(listBlocks.get(numberBlock), listBlocks.get(numberBlock + 1),
                    listBlocks.get(numberBlock + 2), 1));
            listColumns.add(getColumn(listBlocks.get(numberBlock), listBlocks.get(numberBlock + 1),
                    listBlocks.get(numberBlock + 2), 2));
            listColumns.add(getColumn(listBlocks.get(numberBlock), listBlocks.get(numberBlock + 1),
                    listBlocks.get(numberBlock + 2), 3));
        }

        // Valida os blocos

        for (int i = 0; i < listBlocks.size(); i++) {
            if (!validateBlock(listBlocks.get(i))) {
                System.out.println("Block " + (i + 1) + " is not valid");
                return false;
            }
        }

        // Valida as linnhas
        for (int i = 0; i < listLines.size(); i++) {
            if (!validateList(listLines.get(i))) {
                System.out.println("Line " + (i + 1) + " is not valid: " + listLines.get(i));
                return false;
            }
        }

        // Valida as colunas
        for (int i = 0; i < listColumns.size(); i++) {
            if (!validateList(listColumns.get(i))) {
                System.out.println("Column " + (i + 1) + " is not valid: " + listColumns.get(i));
                return false;
            }
        }

        return true;
    }

    private static List<Integer> getLine(Integer[][] block1, Integer[][] block2, Integer[][] block3,
            Integer numberLineInBlock) {
        List<Integer> line = new ArrayList<>();
        // Converte de índice baseado em 1 (1,2,3) para baseado em 0 (0,1,2)
        int index = numberLineInBlock - 1;
        Integer[] lineBlock1 = block1[index];
        Integer[] lineBlock2 = block2[index];
        Integer[] lineBlock3 = block3[index];

        for (int i = 0; i < 3; i++) {
            line.add(lineBlock1[i]);
        }
        for (int i = 0; i < 3; i++) {
            line.add(lineBlock2[i]);
        }
        for (int i = 0; i < 3; i++) {
            line.add(lineBlock3[i]);
        }

        return line;
    }

    private static List<Integer> getColumn(Integer[][] block1, Integer[][] block2, Integer[][] block3,
            Integer numberColumnInBlock) {
        // Converte de índice baseado em 1 (1,2,3) para baseado em 0 (0,1,2)
        int index = numberColumnInBlock - 1;
        List<Integer> column = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            column.add(block1[index][i]);
        }
        for (int i = 0; i < 3; i++) {
            column.add(block2[index][i]);
        }
        for (int i = 0; i < 3; i++) {
            column.add(block3[index][i]);
        }
        return column;
    }

    private static boolean validateList(List<Integer> line) {
        for (int i = 0; i < line.size(); i++) {
            for (int j = i + 1; j < line.size(); j++) {
                if (line.get(i).equals(line.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean validateBlock(Integer[][] block) {
        List<Integer> list = new ArrayList<>();
        
        for (Integer[] line : block) {
            for (Integer number : line) {
                list.add(number);
            }
        }
        
        return validateList(list);
    }


}
