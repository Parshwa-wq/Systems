package Characters;

public class Character {

    /**
     * Basic Attributes
     * 
     * --> Contains some basic variables to identify a Protagonist
     * 
     * #Variables Usecase
     * name --> Name of Protagonist
     * background --> What is his life in Eclipsera
     * role --> What His his job in Game
     * motivation --> Why he wants to leave Eclipsera
     * 
     * #Future Updates
     * -->More Attributes can be added in near Future as game developes
     */
    protected String name;
    protected String background;
    protected String role;
    protected String motivation;

    /**
     * Skills or Ability Attributes
     * 
     * --> As the term suggest it define the skill of Protagonsit his ability
     * --> Skills are closely linked with Role
     * 
     * #Variable Usecase
     * skills --> used to strore Skill of Protagonsit
     * 
     * #Future Updates
     * -->More Attributes can be added in near Future as game developes
     */
    protected String skills;

    /**
     * Status Attributes
     * 
     * --> As the term suggest it defines the current condition of a Protagonsit
     * 
     * #Variable Usecase
     * status :-
     * --> It defines the state of Protagonsit whether He/she is injured or is
     * Fit (more states to be added in the near future).
     * --> It will be used to know whether a Protagonsit can be given a task or Not.
     * --> For example if a Protagonsit is injured you can't give him/her a task.
     * --> Status is closely linked with health
     * 
     * health :-
     * --> It is the health meter of Protagonsit
     * --> its MAX value is 100;
     * 
     * #Future Updates
     * -->More Attributes can be added in near Future as game developes
     */
    protected String status;
    protected int health;

    /**
     * Character Introduction Title
     * this method is used to display title of which Protagonsit is called during
     * introduction phase
     * 
     * 
     * #Method Variable
     * 
     * 1. border
     * --> It's the length of each row where Title can spread
     * 
     * 2. borderStyle
     * --> It is the Design of borders of all four direction of the container in which Title(name) is displayed
     * 
     * #Algorithm
     * 
     * -->First it fetches name of protagonsit
     * 
     * -->Then it prients the name of the protagonsit in a container with a design at borders
     * 
     * @param name Name of Protagonsit
     * 
     */
    public static void characterIntroductionTitle(String name) {

        int borders = 40;
        int spacecount = (borders - name.length() - 2) / 2;
        String borderStyle = "*";

        System.out.println("\n\t\t\t" + borderStyle.repeat(borders));
        System.out.println("\t\t\t*" + " ".repeat(spacecount) + name + " ".repeat(spacecount) + "*");
        System.out.println("\t\t\t" + borderStyle.repeat(borders));
    }
    

    /**
     * Character Dialogue Style One
     * this method is used to display dialogues of Protagonsit
     * Its style 'ONE' further styles will be made in near future
     * 
     * #Method Variable
     * 
     * 1. maxLineLength
     * --> It's the length of each row where dialogue can spread
     * 
     * example
     * if a dialogue contains 50 words and max length
     * of line is assume 20 words then the dialogue will be divided in lines
     * containing words 20, 20 and 10
     * 
     * 2. leftRightBorder
     * --> It is the Design of the 'LEFT' and 'RIGHT' border of dialogue
     * 
     * 3. topBottomBorder
     * --> It is the Design of the 'TOP' and 'BOTTOM' border of dialogue
     * 
     * 4. words
     * --> it is an array of String used to store all the words contained in the
     * dialogue
     * 
     * 5. line
     * --> it is used to divide entire dialogues in lines who have length less than
     * or equal to maxlineLenght
     * 
     * #Algorithm
     * 
     * -->First it store each word in the 'words' array.
     * 
     * -->Then it prients the header portion which contains name of Protagonsit and
     * his mood in a seperate space above the main dialogue box.
     * 
     * -->Then a for loop runs till array length.
     * 
     * -->In it there is condition if line length + side border length exceds max
     * length then it first appends the remaining portion with blank spaces and then
     * prints the line and a new line is formed in the next row.
     * 
     * -->Else words are appended in the line till max length.
     * 
     * -->To print the remaining part (last line with some words) first it appends
     * the remaiing portion with Blank spaces and then prints the last line.
     * 
     * 
     * @param protagonist is the name of the Protagonsit who says the dialogue
     * @param mood        is the mood of the Protagonsit (shocked, existed, happy,
     *                    sad etc)
     * @param dialogue    dialogue what he gonna say.
     * 
     */
    public static void characterDialogueStyleOne(String protagonist, String mood, String dialogue) {

        // Length Per Line
        int maxLineLength = 100;

        // Border Designs
        String leftRightBorder = "//";
        String topBottomBorder = "/";

        // Word Wrapping Variables
        String[] words = dialogue.split(" ");
        StringBuffer line = new StringBuffer("");

        // main design start from here

        System.out.println(leftRightBorder + topBottomBorder.repeat(maxLineLength - (2 * leftRightBorder.length()))
                + leftRightBorder);
        System.out.println(leftRightBorder + " " + protagonist + "( " + mood + " )"
                + " ".repeat(maxLineLength - protagonist.length() - mood.length() - (2 * leftRightBorder.length()) - 6)
                + " " + leftRightBorder);

        for (int i = 0; i < words.length; i++) {
            if (line.length() + words[i].length() + 6 > maxLineLength) {
                while (line.length() + 6 <= maxLineLength) {
                    line.append(" ");
                }
                System.out.println(leftRightBorder + " " + line.toString() + leftRightBorder);
                line = new StringBuffer("");
            }
            line.append(words[i]).append(" ");
        }

        // to print remaining string
        System.out.println(leftRightBorder + " " + line.toString()
                + " ".repeat(maxLineLength - line.length() - (2 * leftRightBorder.length()) - 2)
                + " " + leftRightBorder);

        System.out.println(
                leftRightBorder + " ".repeat(maxLineLength - (2 * leftRightBorder.length())) + leftRightBorder);

        System.out.println(leftRightBorder + topBottomBorder.repeat(maxLineLength - (2 * leftRightBorder.length()))
                + leftRightBorder);
    }

}
