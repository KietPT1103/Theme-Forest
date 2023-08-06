/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nineZ
 */
public class Q1 {

    String inputFile = "ex01_input.txt";
    String outputFile = "ex01_output.txt";

    String fi, fo;

    public void setFile(String[] args) {
        fi = args.length >= 2 ? args[0] : inputFile;
        fo = args.length >= 2 ? args[1] : outputFile;
    }

    BSTree tree;
    ArrayList<Integer> nodeValue;

    // ++++++++++ cau 1 ++++++++++ //
    String preOderResult;
    String postOrderResult;

    // ++++++++++ cau 1 ++++++++++ //
    public void readFile() {
        try (Scanner sc = new Scanner(new File(fi))) {
            // add code here
            nodeValue = new ArrayList<>();
            int n = sc.nextInt();
            int value;

            for (int i = 0; i < n; i++) {
                value = sc.nextInt();
                nodeValue.add(value);
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public void solve() {
        tree = new BSTree();
        for (int i = 0; i < nodeValue.size(); i++) {
            tree.addNode(nodeValue.get(i));
        }

        tree.preOrder();
        preOderResult = tree.getTraversalResult();
        preOderResult = preOderResult.substring(0, preOderResult.length() - 1);

        tree.postOrder();
        postOrderResult = tree.getTraversalResult();
        postOrderResult = postOrderResult.substring(0, postOrderResult.length() - 1);
    }

    public void writeFile() {
        try {
            FileWriter fw = new FileWriter(fo);
            // add code here
            fw.write(preOderResult + "\n");
            fw.write(postOrderResult);

            fw.flush();
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        Q1 app = new Q1();
        app.setFile(args);
        app.readFile();
        app.solve();
        app.writeFile();
    }

}
