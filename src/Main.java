import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {

        // the name of the file name with the information of all the genes of the homo sapiens
        String filename="C:\\Users\\ddunn\\IdeaProjects\\j2b2w2opdracht2\\src\\Homo_sapiens.gene_info";

        // this measures the time it takes to read in the file and stores the information in a linkedlist
        long start_linked_read = System.nanoTime();
        LinkedList<Gene> genes= readFile(filename);
        long end_linked_read=System.nanoTime();

        //this measures the time it takes to read in the file and stores the information in a Arraylist
        long start_array_read =System.nanoTime();
        ArrayList<Gene> genesa = readFileArray(filename);
        long end_array_read=System.nanoTime();

        //this measures the time it takes to select a gene out of a linked list
        long start_linked_select =System.nanoTime();
        Gene item_out_linked= genes.get(6);
        long end_linked_select=System.nanoTime();

        //this measures the time it takes to select a gene out od arraylist
        long start_array_select = System.nanoTime();
        Gene item_out_array =genes.get(6);
        long end_array_select=System.nanoTime();

        //this sorts the genes in the linkedlist
        Collections.sort(genes);
        //this sorts the genes in the arraylist
        Collections.sort(genesa);

        //this groups the Genes in the linkedlist
        LinkedList<Gene>[] groupedGenes= group(genes);
        //this groups the Genes in the arraylist
        ArrayList<Gene>[] groupedGenesA =group(genesa);

        //this prints a array of linkedlists grouped per chromosoom
        System.out.println(Arrays.toString(groupedGenes));

        //this prints a array of Arraylists grouped per chromosoom
        System.out.println(Arrays.toString(groupedGenesA));

        //this calculates all the end times that were measured in the script
        long time_linked_read= end_linked_read-start_linked_read;
        long time_array_read=end_array_read-start_array_read;
        long time_linked_select=end_linked_select-start_linked_select;
        long time_array_select= end_array_select-start_array_select;
        //prints out all the times
        System.out.println(time_linked_read+"\n"+time_array_read+"\n" +time_linked_select+"\n"+time_array_select);
    }

    /**
     * This function groups the data in the linkedlist on basis of Chromosomes
     * @param genes a linkedlist with the sorted information of the human genes
     * @return A array with linkedlists, each linkedlist containing the genes of one chromosome
     */
    public static LinkedList<Gene>[] group(LinkedList<Gene> genes){
        LinkedList[] result = new LinkedList[25];  // makes s linked list with 25 places
        //repeats the process 25 times
        for(int j=0;j<25;j++){
            //initieerd a temporary list that is going to be added to the result
            LinkedList<Gene> temp = new LinkedList<>();
            //intieerd a new linkedlist in the array
            result[j]=new LinkedList<Gene>();
            //loops through all the genes
            for (Gene gene : genes) {
                //checks if the gene is the same as j (an thus need to be in the list where are filling now)
                if (gene.getChromosome() == j) {
                    temp.add(gene);// gets add the to the temporary list
                }
            }
        result[j].add(temp);} // add the temporary list to array of linkedlists

        return result; }


    /**
     * This function groups the data in the arraylist on basis of Chromosomes
     * @param genes a arraylist with the sorted information of the human genes
     * @return A array with arraylists, each arraylist containing the genes of one chromosome
     */
    public static ArrayList<Gene>[] group(ArrayList<Gene> genes){
        ArrayList[] result = new ArrayList[25]; // makes a array with place for 25 arraylists
        // repeats the process 25 times (for the amount of diffrent chromosones
        // including the mitochondrial and X and Y chromosomes)
        for(int j=0;j<25;j++){
            //initieerd a temporary list that is going to be added to the result
            ArrayList<Gene> temp = new ArrayList<>();
            // initieerd a new arraylist in the array
            result[j]=new ArrayList<Gene>();
            for (Gene gene : genes) {
                if (gene.getChromosome() == j) {
                    temp.add(gene);
                }
            }
            result[j].add(temp);}

        return result; }


    /**
     * read in the file, makes a object per line and adds these in a Linkedlist
     * @param filename name of the file containing the information
     * @return genes, a Linkedlist with the Genes contianing the information
     */
    public static LinkedList<Gene> readFile(String filename) {
        String line;
        BufferedReader inFile = null;
        try {
            inFile = new BufferedReader(new FileReader(filename));
            LinkedList<Gene> genes=new LinkedList<>();
            inFile.readLine(); //reads the first line so it gets skipped
            //loops through the rest of the file
            while ((line = inFile.readLine()) != null) {
                String[] attributes=line.split("\t");  //split each line on tab
                //get the gen_id, symbol, chromosome map location and chromosoom out of this array
                int gene_id=Integer.parseInt(attributes[1]);
                String symbol= attributes[2];
                String Chromosome_map_location =attributes[7];
                String Chromosoom= attributes[6];
                // makes a new gene with this information and adds this gene to a Linkedlist
                genes.add(new Gene(gene_id,symbol,Chromosome_map_location,Chromosoom));
            }
            return genes;

        }
        catch (IOException|NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
            return null;
        }
        finally {
            try {
                inFile.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                        e.getMessage());
            }
        }
    }

    /**
     * read in the file, makes a object per line and adds these in a Arraylist
     * @param filename name of the file containing the information
     * @return genes, a Arraylist with the Genes contianing the information
     */
    public static ArrayList<Gene> readFileArray(String filename) {
        String line;
        BufferedReader inFile = null;
        try {
            inFile = new BufferedReader(new FileReader(filename));
            ArrayList<Gene> genes=new ArrayList<>();
            inFile.readLine();   //delete first line
            //loops through the rest of the file
            while ((line = inFile.readLine()) != null) {
                String[] attributes=line.split("\t");// split each line on the tab
                //get the gen_id, symbol, chromosome map location and chromosoom out of this array
                int gene_id=Integer.parseInt(attributes[1]);
                String symbol= attributes[2];
                String Chromosome_map_location =attributes[7];
                String Chromosoom= attributes[6];
                // makes a new gene with this information and adds this gene to a Arraylist
                genes.add(new Gene(gene_id,symbol,Chromosome_map_location,Chromosoom));
            }
            return genes;

        }
        catch (IOException|NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
            return null;
        }
        finally {
            try {
                inFile.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                        e.getMessage());
            }
        }
    }




}
