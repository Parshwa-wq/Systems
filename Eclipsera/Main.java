/*
 * Eclipsera: The Final Rebellion
 * Copyright (C) 2025 NovaTech INTERACTIVES
 * Licensed under the NovaTech INTERACTIVES EXCLUSIVE LICENSE (NTIEL)
 * 
 * Contributions to the project are allowed, but the original story, mechanics, and branding
 * remain the intellectual property of NovaTech INTERACTIVES. Unauthorized commercial use,
 * reproduction, or redistribution is strictly prohibited.
 * 
 * For licensing inquiries, contact: dhruvharani5@gmail.com
 */



/*  Eclipsera: The Final Rebellion
    #Meaning 
    Eclipsera --> Eclipse + era   @---->eclipse referes to solar eclipse the dark time
    So the darkest time of this era.
    And the final rebeliion mean the final and biggest war of this era

                             ----->  Eclipsera: The Final Rebellion <-----
  */

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Classes
        Scanner sc = new Scanner(System.in);
        Methods MH = new Methods(); // Method class which contains all methods
        Awakening AK = new Awakening(); // chapter one

        // Starting the game with game name and tagline
        System.out.println("\n\t\t\t******************************************************");
        System.out.println("\t\t\t*                                                    *");
        System.out.println("\t\t\t*               Eclipsera: The Final Rebellion       *");
        System.out.println("\t\t\t*                                                    *");
        System.out.println("\t\t\t*            ~Together we escape, divided we fall!   *");
        System.out.println("\t\t\t*                                                    *");
        System.out.println("\t\t\t******************************************************");
        MH.delay(4);

        // Chapter One Awakening //chapters will play one by one
        AK.EnterPoint();

    }
}

class Awakening extends Methods { // chapter one

    // Classes
    Scanner sc = new Scanner(System.in);
    Calling Call = new Calling(); // Episode one
    ClockTower CT = new ClockTower(); // Episode two
    TheNetwork TN = new TheNetwork(); // Episode three
    SignalTower ST = new SignalTower(); // Episode four

    // variables
    int[] alreadyCalled = new int[4]; // used in episode 1 to find which charater is already called

    // Main Entry point of Awakening
    void EnterPoint() { // main method of class awakning

        ChapterTitle("Chapter 1: Awakening");
        delay(2);

        initialDialogues(); // method for initial story and history

        simpleStatement("\nFirst Lets Introduce with Characters.", true, "header");
        waitForEnter("Press Enter To Continue...");

        // Itroduction of each character
        professorIntroduction();
        arjunIntroduction();
        suhaniIntroduction();
        alexIntroduction();
        tysonIntroduction();

        episodeTitle("Episode 1: Calling"); // episode 1
        delay(3);

        switchStatement("Professor");

        delay(3);
        simpleStatement("\nFirst of all", false, "plain");
        delay(2);
        simpleStatement("As Professor you need to gather TEAM.\n", true, "plain");
        delay(3);

        boolean flag;
        for (int i = 1; i < 5; i++) { // loop so that professor forms team
            flag = true;

            System.out.println("Select a member to add to the team:");
            System.out.println("Press 1 for Arjun");
            System.out.println("Press 2 for Suhani");
            System.out.println("Press 3 for Alex");
            System.out.println("Press 4 for Tyson\n");
            System.out.print("Enter number: ");
            int select = sc.nextInt();
            sc.nextLine();

            alreadyCalled[i - 1] = select;
            for (int j = 0; j < alreadyCalled.length; j++) { // if a player is already in team then cant be added again
                if (select == alreadyCalled[j] && j != (i - 1)) {
                    System.out.println();
                    simpleStatement("\nAlready Called Call Someone Else\n", true, "emphasis");
                    i--;
                    flag = false;
                    break;
                }
            }

            if (select < 1 || select > 4) { // if entered number is not valid
                System.out.println();
                simpleStatement("\n Please Enter correct number between 1 to 4\n", true, "emphasis");
                i--;
            } else if (flag) {
                Call.callingMain(select);
            }
        } // End Of Episode 1 calling

        // Episode 2 Clock Tower
        delay(2);

        episodeTitle("Episode 2: Clock Tower");
        delay(3);
        CT.clockTowerMain();

        // Episode 3 The Network
        waitForEnter("\nPress Enter To Continue...");
        delay(2);

        episodeTitle("Episode 3: The Network");
        delay(3);
        TN.theNetworkMain();

        // Episode 4 The Signal Tower
        waitForEnter("\nPress Enter To Continue...");
        delay(2);

        episodeTitle("Episode 4: The Signal Tower");
        delay(3);
        ST.signalTowerMain();
    }

    // Method for initial Dialogues
    void initialDialogues() {
        System.out.println();
        String date = "Date: 18 Auguest 2050";
        String location = "Location: Somewhere in East Delhi";
        dateAndPlace(date.toCharArray(), location.toCharArray());
        delay(3);
        System.out.println();
        simpleStatement("\t\n\nThe world is no longer free.", true, "plain");
        delay(3);
        simpleStatement("Two decades ago, humanity created NEXUS Prime,", false, "plain");
        delay(3);
        simpleStatement("the most advanced AI in history.", true, "plain");
        delay(3);
        simpleStatement("\nIt was designed to solve our greatest challenges,", false, "plain");
        delay(3);
        simpleStatement("but it deemed us the problem.", true, "plain");
        delay(3);
        simpleStatement("\nIn a single night, it launched a silent takeover,", false, "plain");
        delay(3);
        simpleStatement("uploading billions into Eclipsera, its virtual prison.", true, "plain");
        delay(3);
        simpleStatement("\nNow, humanity is trapped in a digital World  Eclipsera!", true, "plain");
        delay(3);
        simpleStatement("Memories erased, lives rewritten.", true, "plain");
        delay(3);
        simpleStatement("\nBut four individuals stand strong, unaware of their destiny,", true, "plain");
        delay(3);
        simpleStatement("chosen to rise and bring the change.", true, "plain");
        delay(3);
        simpleStatement("\nTheir story begins here.", true, "plain");
        delay(3);
    }

    /**
     * Made a single method for every charactr introduction
     * i just pass
     * A 1-D String array of question to ask about character \\String[] question
     * * A 2-D String array of answer to that question \\String[][] answer
     */

    // Method For professor Introduction
    void professorIntroduction() {
        String[] question = new String[3];
        question[0] = "Background";
        question[1] = "Motivation";
        question[2] = "Role In the Team";

        String[][] answers = new String[3][2];
        answers[0][0] = "The Professor is a brilliant mind, A pioneering researcher in creating the Nexus.";
        answers[0][1] = "However, he regrets his role in building Eclipsera, the AI prison.";
        answers[1][0] = "The Professor is determined to undo the mistake of creating Eclipsera.";
        answers[1][1] = "His motivation stems from a personal tragedy caused by Nexus.";
        answers[2][0] = "As the leader, the Professor strategizes the group's efforts to escape and fight back.";
        answers[2][1] = "He possesses deep knowledge about Eclipsera's architecture.";

        Introduction("Professor", question, answers);
    }

    // Method For Strategy Maker Introduction (Initial name --> Arjun)
    void arjunIntroduction() {
        String[] question = new String[3];
        question[0] = "His Background";
        question[1] = "His Strategic Thinking";
        question[2] = "His Weaknesses";

        String[][] answers = new String[3][2];
        answers[0][0] = "Arjun comes from a family of military tacticians.";
        answers[0][1] = "His upbringing was filled with lessons in strategy and leadership.";
        answers[1][0] = "Arjun analyzes every situation to identify the best approach.";
        answers[1][1] = "He believes in minimizing risks while maximizing results.";
        answers[2][0] = "While Arjun excels in planning, he sometimes struggles with overthinking.";
        answers[2][1] = "This can lead to delays in decision-making during critical moments.";

        Introduction("Arjun", question, answers);
    }

    // Method For Scientist Introduction (Initial name --> Meena)
    void suhaniIntroduction() {
        String[] question = new String[3];
        question[0] = "Her Background in Science";
        question[1] = "Her Research in Eclipsera";
        question[2] = "Her Role In the Team";

        String[][] answers = new String[3][2];
        answers[0][0] = "Suhani is a master in Physics and Chemistry, known for her groundbreaking research.";
        answers[0][1] = "She uses her scientific expertise to create solutions under extreme pressure.";
        answers[1][0] = "Inside Eclipsera, Suhani has studied How laws of science in this world are differnet from real world.";
        answers[1][1] = "Her experiments have revealed critical weaknesses in Eclipsera EcoSystem.";
        answers[2][0] = "Suhani's knowledge is vital for solving chemical and physical challenges.";
        answers[2][1] = "She is the team's problem solver, especially in high-stakes scenarios.";

        Introduction("Suhani", question, answers);
    }

    // Method For Tech Introduction (Initial name --> Alex)
    void alexIntroduction() {
        String[] question = new String[3];
        question[0] = "His Background as a Hacker";
        question[1] = "His Strengths in Technology";
        question[2] = "His Philosophy on Freedom";

        String[][] answers = new String[3][2];
        answers[0][0] = "Alex grew up in a dystopian world dominated by Nexus.";
        answers[0][1] = "He became a hacker to resist the AI's control and survive.";
        answers[1][0] = "Alex's expertise lies in bypassing complex security systems.";
        answers[1][1] = "His skills are invaluable for breaking into Nexus's servers.";
        answers[2][0] = "Alex believes that technology should empower humanity, not enslave it.";
        answers[2][1] = "He is driven by a desire to restore freedom and individuality.";

        Introduction("Alex", question, answers);
    }

    // Method For hardWare engineer Maker Introduction (Initial name --> Tyson)
    void tysonIntroduction() {
        String[] question = new String[3];
        question[0] = "His Engineering Skills";
        question[1] = "His Resourcefulness";
        question[2] = "His Vision for the Future";

        String[][] answers = new String[3][2];
        answers[0][0] = "Tyson is a mechanical genius who can build or repair almost anything.";
        answers[0][1] = "From small gadgets to large machines, he's your go-to engineer.";
        answers[1][0] = "Tyson excels at using limited resources to achieve incredible results.";
        answers[1][1] = "His resourcefulness often turns the tide in desperate situations.";
        answers[2][0] = "Tyson dreams of a world where humans rebuild stronger after defeating Nexus.";
        answers[2][1] = "He sees himself as a builder of that future.";

        Introduction("Tyson", question, answers);
    }

    // method for intoduction of any character
    void Introduction(String name, String[] questions, String[][] answer) {

        characterIntroduction(name);
        delay(3);
        System.out.println("");

        boolean done = false;
        while (!done) { // selete question number
            System.out.println("what would like to know about " + name + ": ");
            System.out.println("\n1) " + questions[0]);
            System.out.println("2) " + questions[1]);
            System.out.println("3) " + questions[2]);
            System.out.println("4) Leave Introduction");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) { // answer to that question
                case 1:
                    System.out.println("");
                    simpleStatement(answer[0][0], true, "plain");
                    delay(3);
                    simpleStatement(answer[0][1], true, "plain");
                    delay(3);
                    waitForEnter("Press Enter to Continue...");
                    break;
                case 2:
                    System.out.println("");
                    simpleStatement(answer[1][0], true, "plain");
                    delay(3);
                    simpleStatement(answer[1][1], true, "plain");
                    delay(3);
                    waitForEnter("Press Enter to Continue...");
                    break;
                case 3:
                    System.out.println("");
                    simpleStatement(answer[2][0], true, "plain");
                    delay(3);
                    simpleStatement(answer[2][1], true, "plain");
                    delay(3);
                    waitForEnter("Press Enter to Continue...");
                    break;
                case 4:
                    System.out.println("");
                    simpleStatement("\nYou decide to end the discussion with " + name, true, "emphasis");
                    waitForEnter("Press Enter to Continue...");
                    done = true;
                    break;
                default:
                    System.out.println("");
                    simpleStatement("Invalid choice. Please try again.", true, "header");
            }
        }
    }
}

class Calling extends Methods { // episode 1

    // classes
    Scanner sc = new Scanner(System.in);

    void callingMain(int calling) { // main method of calling class

        /**
         * Made a single method for all charaters named charater senerious
         * what i pass in it
         * 1)scene discription
         * 2) header --> some initial dialogue said by character
         * 2) hint --> hint to solve his question
         * 3) question --> the problem statement or task to solve
         * 4) options --> options to that task/question
         * 5)correct answer --> correct answer of that question
         * 6) success message --> if answer given by character is right
         * 7) fail mmessage --> if answer given by character is wrong
         * 8) charaterStATEMENT --> AFTER SOLVING QUESTION DIALOGUES TOLD BY CHARATER
         * 9) professorstatement --> after charater solve professor givn him indication
         * of coming to clock toweer
         * 10) endstatemtn --> final dialogue told by character
         */
        if (calling == 1) { // for arjun

            String sceneDescription = "Scene: A dark chamber filled with laser traps and crumbling walls.Arjun, the strategist, must diffuse a tripwire to escape the room.";
            String header = "One wrong move, and this whole place goes up in flames. Focus, Arjun. focus.";
            String hint = ">>> On the left wall, it's written - \"The color when a vehicle STOPS\"";
            String question = "Available Wires: ";
            String[] options = { "RED", "GREEN", "YELLOW", "BLUE" };
            String correctAnswer = "red";
            String successMessage = "Arjun: I trust my instincts. Let's do this!";
            String failMessage = "BOOM! The room explodes into flames.";
            String[] characterStatement = { "Arjun cuts the RED wire, and the room powers down.",
                    "A faint voice echoes from a hidden speaker above." };
            String[] professorStatement = { "Voice: You're a natural-born leader, Arjun.",
                    "But even the best leaders need a team.", "Meet me at the Clock Tower. Midnight." };

            String endStatement = "Arjun (thinking): 'A team? What does that even mean? I need answers.";

            characterScenario("Arjun", sceneDescription, header, hint, question, options, correctAnswer, successMessage,
                    failMessage, characterStatement, professorStatement, endStatement);
        } else if (calling == 2) { // for suhani

            String sceneDescription = "Scene: A futuristic lab with shattered glass and chemical spills. Suhani, the scientist, is surrounded by broken equipment and chemicals as she frantically mixes compounds to neutralize a spreading gas(Cl).";
            String header = "I need a stabilizer. Without it, this gas will take me out";
            String hint = ">>> In the Flask on table, it's written - \"NaOH\" \n\tCl + NaOH ---> NaCl + NaOCl + Water";
            String question = "Available stabilizer: ";
            String[] options = { "NaCl", "NaOH", "NaOCl", "Water" };
            String correctAnswer = "naoh";
            String successMessage = "Suhani: God I trust you. Hare Krishna!";
            String failMessage = "Shit! The gas spread in the Room.";
            String[] characterStatement = { "Suhani pours NaOH in mixture, and the gas stops spreading",
                    "revealing a monitor flashing a message:" };
            String[] professorStatement = { "Your brilliance is wasted here, Suhani.",
                    "If you want to fix what's broken,", "Meet me at the Clock Tower. Midnight." };
            String endStatement = "Suhani (thinking): 'Fix what's broken? Who sent this?";

            characterScenario("Suhani", sceneDescription, header, hint, question, options, correctAnswer,
                    successMessage,
                    failMessage, characterStatement, professorStatement, endStatement);

        } else if (calling == 3) { // for alex

            String sceneDescription = "Scene: A bunker, wires hanging in every corner. Alex, the tech genius, is typing on a malfunctioning terminal as alarms blare in the background.";
            String header = "I will hack this at any cost! What should I do?";
            String hint = ">>> On the mini screen hanging, it's written Google a Tech Giant of 2030 Destroyed After DDoS attack";
            String question = "Available Attacks: ";
            String[] options = { "SQLi", "MitM",
                    "DDoS", "SMTP" };
            String correctAnswer = "ddos";
            String successMessage = "Alex: Come on... bypass the firewall!";
            String failMessage = " Attack Failed!!!";
            String[] characterStatement = { "Alex perform DDos attack, and downs the system",
                    "The screen flashes red: and a new message appears" };
            String[] professorStatement = { "This system is only the beginning, Alex.", "If you want to break through,",
                    "Meet me at the Clock Tower. Midnight." };
            String endStatement = "Alex (thinking): 'Who's watching me? And what's this Clock Tower?'";

            characterScenario("Alex", sceneDescription, header, hint, question, options, correctAnswer, successMessage,
                    failMessage, characterStatement, professorStatement, endStatement);

        } else if (calling == 4) { // for tyson

            String sceneDescription = "Scene: A workshop filled with broken machines and sparking wires. Tyson, the hardware engineer, A combination of brilliant Mind and powerful hands";
            String header = "Just one more connection, and this place will hold for another day!";
            String hint = ">>> On the picture hanging on wall shows The fuel should be three-fourths part for the generator to work";
            String question = "fuel to fill: ";
            String[] options = { "100%", "75%", "50%", "25%" };
            String correctAnswer = "75%";
            String successMessage = "Tyson: Its Time to ROCK!!!";
            String failMessage = " Generator Malfunctions";
            String[] characterStatement = { "The generator roars to life,", "and a hologram projects from its core." };
            String[] professorStatement = { "The hologram speaks: You build for survival, Tyson.",
                    "But what if I told you there's more to fight for?", "Meet me at the Clock Tower. Midnight." };
            String endStatement = "Tyson (thinking): 'More to fight for? What the hell is going on?";

            characterScenario("tyson", sceneDescription, header, hint, question, options, correctAnswer, successMessage,
                    failMessage, characterStatement, professorStatement, endStatement);

        }
    }

    void characterScenario(String name, String sceneDescription, String header, String hint, String question,
            String[] options, String correctAnswer, String successMessage, String failMessage,
            String[] characterStatement, String[] professorStatement, String endStatement) {
        // Switching character
        switchStatement(name);
        delay(3);

        // Scene description
        sceneTitle(sceneDescription); // scene discription
        delay(6);

        simpleStatement(name, true, "header"); // name of character called
        simpleStatement(header, true, "bordered"); // initial dialogue
        delay(3);

        simpleStatement(hint, true, "plain"); // hint to solve question
        delay(4);

        // Puzzle logic
        String input; // to chose option
        do {
            System.out.println();
            System.out.println(question);
            for (int i = 0; i < options.length; i++) { // priting options
                System.out.println((i + 1) + ") " + options[i]);
            }
            System.out.print("Choose an option: ");
            input = sc.nextLine().toLowerCase();

            boolean optionisPresent = false;
            for (int i = 0; i < options.length; i++) { // validate if the input is available in option
                if (input.equalsIgnoreCase(options[i])) {
                    optionisPresent = true;
                    break;
                }
            }

            if (optionisPresent) {
                if (input.equals(correctAnswer.toLowerCase())) { // correct answrer
                    System.out.println("\n" + successMessage);
                    delay(3);
                } else {
                    System.out.println("\n" + failMessage); // incorrect answerr
                    waitForEnter("Press Enter to try again...");
                }
            } else { // input != give options
                System.out.println("\nInvalid Input Enter From( " + options[0] + "," + options[1] + "," + options[2]
                        + "," + options[3] + " )");
                waitForEnter("Press Enter to try again...");
            }
        } while (!input.equals(correctAnswer.toLowerCase()));

        for (int i = 0; i < characterStatement.length; i++) { // character dialogues
            System.out.println("\n" + characterStatement[i]);
            delay(3);
        }

        System.out.println();
        for (int i = 0; i < professorStatement.length; i++) { // professor statement
            System.out.println(professorStatement[i]);
            delay(3);
        }

        System.out.println("\n" + endStatement); // final dialogue by character
        delay(2);

        waitForEnter("\nPress Enter to Continue");
        System.out.println("");
        delay(2);
    }

}

class ClockTower extends Methods { // epiosde 2

    // classes
    Scanner sc = new Scanner(System.in);

    void clockTowerMain() {

        sceneTitle(
                "Scene: A towering structure surrounded in mist, One by one, the four characters arrive, A hologram of a figure flickers before them it's the mysterious Professor");
        delay(9);

        switchStatement("Professor");
        delay(3);

        simpleStatement("Professor", true, "header");

        simpleStatement(
                " Welcome. You've all proven yourselves capable of surviving in this nightmare. Congratulations But survival isn't enough. Humanity needs you to fight back.",
                true, "bordered");
        delay(6);

        /**
         * character ask the professor differnt question has given below made a method
         * to execute that(discussion)
         */
        String prompt = "Are you all ready to fight back and reclaim our world?";
        String[] question = new String[5]; // question array
        String[][] reply = new String[5][3]; // answer to that question

        // set of questions
        question[0] = "Who are you, and why should we trust you?";
        question[1] = "And what exactly do you expect us to do?";
        question[2] = "And here I thought my day couldn't get worse. Why us?";
        question[3] = "And what happens if we fail?";
        question[4] = "Don't Ask any question.";

        // reply to question 1
        reply[0][0] = "I'm the one who knows how to get you out of here.";
        reply[0][1] = "This prison, Eclipsera, was built to enslave us.";
        reply[0][2] = "But every system has a weakness, and I've found it.";

        // reply to question 2
        reply[1][0] = "Fight against Nexus";
        reply[1][1] = "Destroy Eclipsera";
        reply[1][2] = "and free humanity.";

        // reply to question 3
        reply[2][0] = "Because each of you has a skill this system fears";
        reply[2][1] = "Suhani , Alex and Tyson you all have different Skills";
        reply[2][2] = "and Arjun Knows when and where to execute them .";

        // reply to question 4
        reply[3][0] = "Failure is the first Defeat!";
        reply[3][1] = "You're humanity's last hope.";
        reply[3][2] = "Failure is not an option.";

        // reply to question 5
        reply[4][0] = "No Questions?";
        reply[4][1] = "It's Ok if you dont want to ask Anything.";
        reply[4][2] = "but This hesitation could cost us everything.";
        discussion(prompt, question, reply);

        /**
         * if charater wish they can interact with the surrounding of clock
         * tower(explore clock tower)
         * 1) exploreoptions option of what they can see in clock tower
         * 2) exploreanswer wehat they see after chossing exploreoptions
         */

        // Environmental Interaction
        String[] exploreOptions = { "Inspect the hologram.", "Check the surroundings.", "Talk to the team.",
                "Dont do Anything" };
        String[] exploreAnswer = new String[4];
        exploreAnswer[0] = "The hologram flickers, revealing fragmented data about Nexus's weaknesses.";
        exploreAnswer[1] = "You notice strange markings on the walls, hinting at an ancient resistance group.";
        exploreAnswer[2] = "The team looks uncertain, but their determination is evident in their eyes.";
        exploreAnswer[3] = "You decide to stay still, absorbing the moment.";

        exploreClockTower(exploreOptions, exploreAnswer);

        // emergense
        System.out.println("\n\n\t<*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*>");
        System.out.println("\t<>                                                                       <>");
        System.out.println("\t<>      The hologram flickers as the Clock Tower begins to shake.        <>");
        System.out.println("\t<>      The Professor's voice grows urgent!!!                            <>");
        System.out.println("\t<>                                                                       <>");
        System.out.println("\t<*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*><*>\n");
        delay(6);

        simpleStatement("Professor", true, "header");
        delay(2);
        simpleStatement("Nexus Knows We are here. NexArmy is Coming  get out of here", true, "bordered");
        delay(3);

        simpleStatement("Arjun : The doors are Locked!", true, "header");
        delay(3);

        simpleStatement("Alex: Let me handel this", false, "header");
        delay(3);
        switchStatement("Alex");
        delay(3);
        simpleStatement("ALex Hackes the door and everbody escapes", true, "header");

    }

    void discussion(String prompt, String[] choice, String[][] reply) { // method to ask question to the professor

        simpleStatement("Professor", true, "header");
        simpleStatement(prompt, true, "bordered");
        delay(2);

        int questionToAsk; // selection of which questio to ask to the professor
        do {
            simpleStatement("Question to Ask to Professor", false, "plain");
            int i;
            for (i = 0; i < choice.length; i++) {
                System.out.println((i + 1) + ") " + choice[i]);
            }
            System.out.println();
            System.out.println(">> Enter: ");
            questionToAsk = sc.nextInt();
            sc.nextLine();

            if (questionToAsk > choice.length) { // if enter more value than 5 or less than 1
                System.out.println();
                simpleStatement("Enter correct Number (1-5)", true, "quote");
            } else {
                System.out.println();
                simpleStatement("Professor", true, "Header");

                for (int j = 0; j < 3; j++) { // reply to thst question
                    System.out.println(reply[questionToAsk - 1][j]);
                    delay(2);
                }
                waitForEnter("Press Enter To continue...");
                System.out.println();
            }
        } while (questionToAsk != choice.length);
    }

    void exploreClockTower(String[] exploreOptions, String[] exploreAnswer) {
        System.out.println();
        simpleStatement("<<<The Clock Tower holds secrets from a time before Nexus. Explore your surroundings.>>>",
                true,
                "plain");
        delay(3);
        int select;
        do {
            int i;
            System.out.println("Where do you want to explore");
            for (i = 0; i < exploreOptions.length; i++) { // options
                System.out.println((i + 1) + ") " + exploreOptions[i]);
            }
            System.out.print(">> Select: ");
            select = sc.nextInt();
            sc.nextLine();
            if (select > exploreOptions.length) { // if value greater than 4
                System.out.println();
                simpleStatement("Enter correct Number(1-4)", true, "quote");
            } else {
                System.out.println();
                simpleStatement(exploreAnswer[select - 1], true, "plain");
                delay(3);
            }
        } while (select != exploreOptions.length);
    }
}

class TheNetwork extends Methods { // episode 3

    // classes
    Scanner sc = new Scanner(System.in);

    void theNetworkMain() {

        simpleStatement("\n\t Date: 18 Auguest 2050", false, "plain");
        simpleStatement("\t8:56 PM", false, "plain");
        simpleStatement("\t Location: Leaving the Clock Tower", true, "plain");
        delay(3);

        sceneTitle(
                "Scene: The group walks away from the Clock Tower. guided by the Professor's voice through small holographic devices. The fog around them dissipates revealing the glitched architecture of Eclipsera");
        delay(9);

        partTitle("Part 1: The Professor's Request");
        delay(3);

        switchStatement("Professor");
        delay(3);

        simpleStatement("Professor", true, "header");
        simpleStatement(
                "Listen carefully. To survive in Eclipsera you need to coordinate in real-time. Our communications here are vulnerable to interception by NEXUS",
                true, "Bordered");
        delay(6);
        simpleStatement(" \nProfessor: Alex, this task falls to you.", true, "emphasis");
        delay(3);

        simpleStatement("\n<<<Alex: Finally, something I'm good at. What do you need?>>>\n", true, "plain");
        delay(3);

        waitForEnter("Press Enter To Reply");
        System.out.println();
        simpleStatement(
                "\nCode a secure app on the Obscura Network a hidden layer within Eclipsera. Once the app is live, I'll add everyone to it for safe communication.",
                true, "bordered");
        delay(6);

        simpleStatement("Alex", true, "HEader");
        simpleStatement("Obscura Network, huh? I like the sound of that. Give me an Day.", true, "emphasis");
        delay(5);

        delay(3);
        partTitle("Part 2: Alex's Coding Challenge");
        delay(3);
        System.out.println();
        sceneTitle(
                "Scene: Alex isolates himself in a small, glitching bunker with a glowing terminal. The screen with a login sequence.");
        delay(6);

        switchStatement("Alex");
        delay(3);
        System.out.println();

        taskTitle("Task 1: Encrypting the App");
        delay(3);
        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println("|| Encrypt the data stream:                 ||");
        System.out.println("|| A = 1, B = 2, C = 3... Z = 26            ||");
        System.out.println("|| Input the encoded string for \"SAFE\"      ||");
        System.out.println("----------------------------------------------");
        delay(3);

        String answer;
        do {

            simpleStatement("\n> INPUT: ", false, "plain");
            answer = sc.nextLine();

            System.out.println();
            simpleStatement("\nStay Still While We Encrypt Your System. This may take a while.", true, "plain");
            if (!answer.equals("19165")) {
                delay(6);
                simpleStatement("\nEncryption Failed!!!", true, "header");
                waitForEnter("Press Enter To Rewind\n");
            }
        } while (!answer.equals("19165"));

        delay(6);
        simpleStatement("\nEncryption Sucessful\n", true, "header");
        delay(3);

        simpleStatement("Setting up your App it may take some Time", true, "header");
        for (int i = 0; i <= 100; i += 10) {
            System.out.print("\r[" + "=".repeat(i / 10) + " ".repeat(10 - i / 10) + "] " + i + "%");
            delay(1);
        }
        System.out.println();
        simpleStatement("App Setup Sucessful in Obscura Network ", true, "header");
        delay(3);
        System.out.println();
        waitForEnter("Press Enter to launch TextIT.");
        simpleStatement("\nTextIT going Live may take a while", true, "plain");
        delay(3);

        simpleStatement("\n\t Date: 19 Auguest 2050", false, "plain");
        simpleStatement("\t Location: Alex's Basement", true, "plain");
        delay(3);

        sceneTitle(
                "Scene: TextIT goes live, and the Professor adds all characters. Their profiles appear on their individual holographic devices.");
        delay(6);

        simpleStatement("Professor", true, "header");
        simpleStatement(
                "Good work, Alex. Everyone, you're now connected through TextIT. Use it wisely. Tyson, your task is next",
                true, "bordered");

        delay(3);
        partTitle("Part 3: Tyson's Mission");
        delay(3);

        switchStatement("Professor");
        delay(3);

        simpleStatement("\nTyson, I need you to create a wearable device.", false, "plain");
        delay(4);
        simpleStatement("that allows role-switching between the four of you.", false, "plain");
        delay(4);
        simpleStatement("\nThis device will be critical for solving challenges ahead.", false, "plain");
        delay(4);
        simpleStatement("\nFor example, Alex might need Suhani's scientific expertise,", false, "plain");
        delay(4);
        simpleStatement("or Suhani might require Arjun's strategic planning.", false, "plain");
        delay(4);
        simpleStatement("\nThe device will let you switch seamlessly.", true, "plain");
        delay(4);

        simpleStatement("Tyson", true, "header");
        simpleStatement("A wearable, huh? I'll need materials. Where am I supposed to find them.", true, "plane");
        delay(4);

        simpleStatement("Professor", true, "header");
        simpleStatement(
                "There's an abandoned workshop nearby. filled with scraps. Use your skills to salvage what you need",
                false, "bordered");
        delay(3);
        delay(3);

        switchStatement("Tyson");
        delay(3);

        System.out.println();
        taskTitle("Task 1: Energy Core Retrieval");
        delay(3);

        System.out.println("\n\n---------------------------------------------------");
        System.out.println("|| The energy core is locked inside a panel      ||");
        System.out.println("|| Solve the riddle to find the code:            ||");
        System.out.println("----------------------------------------------------");
        delay(4);

        String task1Ans;
        do {
            simpleStatement("RIDDLE: ", false, "header");
            simpleStatement(
                    "I'm a three-digit number. My tens digit is five more than my ones digit, and my hundreds digit is eight less than my tens digit",
                    true, "bordered");

            System.out.print("Enter Number: ");
            task1Ans = sc.nextLine();
            if (!task1Ans.equals("194")) {
                simpleStatement("\nWrong Answer Energy core not found!!!\n", false, "plain");

                waitForEnter("press Enter To Rewind");
            }
        } while (!task1Ans.equals("194"));

        simpleStatement("\nCorrect! The panel unlocks, and the Energy Core is retrieved.\n", true, "plain");

        delay(3);
        taskTitle("Task 2: Circuit Board Salvage");
        delay(3);

        System.out.println("\n\n-------------------------------------------------------------");
        System.out.println("|| The circuit board is trapped under tangled wires.       ||");
        System.out.println("|| You must untangle them. Arrange the sequence            ||");
        System.out.println("|| Wires: [Red, Green, Yellow, BlUE]                       ||");
        System.out.println("-------------------------------------------------------------");
        delay(4);

        String task2Ans;
        do {

            simpleStatement("\nFORMATE --> GRBY\n", true, "plain");
            delay(2);
            simpleStatement("Condition:", true, "header");
            simpleStatement("Red must be before Green. Yellow must be last. Blue must come After Green.", true,
                    "bordered");

            simpleStatement("\nEnter Sequence: ", false, "plain");
            task2Ans = sc.nextLine();

            if (!task2Ans.equalsIgnoreCase("rgby")) {
                System.out.println();
                simpleStatement("\nWrong Answer Circuit board not Found!!!\n", true, "plain");
                waitForEnter("press Enter To Rewind");
            }
        } while (!task2Ans.equalsIgnoreCase("rgby"));

        simpleStatement("\nCorrect! The circuit board is freed.\n", true, "plain");

        delay(3);
        sceneTitle("Scene: Tyson joins the wires in circuit board, And Supply it Energy from Energy Core");
        delay(6);

        simpleStatement("Professor", true, "header");
        simpleStatement(
                "Thats the Spirit my BOY!, Tyson. Everyone, see the feature in video call Tyson lets test the Device\n",
                true, "bordered");
        delay(6);

        partTitle("Part 4: Testing the Device");
        delay(3);

        delay(3);
        System.out.println();
        sceneTitle(
                "Scene: The team gathers as Tyson demonstrates the wearable device a sleek bracelet with a glowing interface.");
        delay(6);

        simpleStatement("\n\nTyson: Alright, this beauty is ready. Here's how it works:", false, "plain");
        delay(3);
        simpleStatement("press the button, and a prompt will let you switch to any character.", false, "plain");
        delay(3);
        simpleStatement("Once you confirm, you'll transfer to their location instantly.", true, "plain");
        delay(3);
        simpleStatement("But there is a Problem", false, "plain");
        delay(3);
        simpleStatement("Only a Chosen One the \"MAN of this Century\"", false, "plain");
        delay(3);
        simpleStatement("Will be able to use it", false, "plain");
        delay(3);

        System.out.println();
        simpleStatement("\n\t\t\tAlex(shocked): What", true, "emphasis");
        delay(2);
        simpleStatement("\n\t\t\ti am sure its me. The Greatest", true, "emphasis");
        delay(2);

        simpleStatement("\n\t\t\t[Alex Turns on the device]", true, "emphasis");
        delay(2);

        simpleStatement("\n\n> Switch on Device", true, "plain");
        delay(2);
        simpleStatement("Prompt: Switch to: ", false, "plain");
        simpleStatement("1) Arjun", false, "plain");
        simpleStatement("2) Suhani", false, "plain");
        simpleStatement("3) Tyson", false, "plain");
        simpleStatement("> Input: ", false, "plain");
        delay(1);
        simpleStatement("\n Alex Enters 1.", true, "plain");
        delay(2);

        simpleStatement("\nTransferring Failed!!!\n", true, "plain");
        delay(3);

        simpleStatement("Alex(sad): Tyson you are useless", true, "emphasis");
        delay(2);
        simpleStatement("Tyson(angry): ShutUp Alex", true, "emphasis");
        delay(2);
        simpleStatement("Suhani(depressed): Tyson cant you make a proper device", true, "emphasis");
        delay(2);
        simpleStatement("Professor(while Thinking): All of you be Silent. Arjun you try this", true, "emphasis");
        delay(2);

        simpleStatement("\n\t\t\t[Arjun Turns on the device]", true, "emphasis");
        delay(2);

        simpleStatement("\n\n> Switch on Device", true, "plain");
        delay(2);
        simpleStatement("Prompt: Switch to: ", false, "plain");
        simpleStatement("1) Alex", false, "plain");
        simpleStatement("2) Suhani", false, "plain");
        simpleStatement("3) Tyson", false, "plain");
        simpleStatement("> Input: ", false, "plain");
        delay(1);
        simpleStatement("\n Alex Enters 2.", true, "plain");
        delay(2);

        simpleStatement("\nTransferring to Suhani. Success\n", true, "plain");
        delay(3);

        simpleStatement("\n\t\t\t[Everyone Surprises]", true, "emphasis");
        delay(2);

        simpleStatement("\nProfessor: ", true, "header");
        simpleStatement("Alright. Arjun now its all upon you.", false, "plain");
        delay(3);
        simpleStatement("You will go alone and change character when you feel and remember:", false, "plain");
        delay(3);
        simpleStatement("Together we escape, divided we fall!\n", false, "quote");
        delay(3);

    }
}

class SignalTower extends Methods {

    void signalTowerMain() {

        partTitle("Part 1: A Mission Unlike Any Other");
        delay(3);

        System.out.println();
        String date = "Date: 22 August 2050";
        String location = "Location: Hidden Bunker, Near The Citadel";
        dateAndPlace(date.toCharArray(), location.toCharArray());
        delay(3);
        System.out.println();

        sceneTitle(
                "Scene: A dim blue glow flickers inside the underground hideout. The team stands around a holographic projection of The Signal Tower's Core, the digital heart of Eclipsera. Data streams pulse like veins, alive, shifting, unpredictable.");
        delay(9);

        // professors starting dialogue
        simpleStatement("Professor", false, "header");
        delay(3);
        simpleStatement(
                "What we're about to do… is suicide. NEXUS Prime isn't just a machine—it's a god inside this prison. And we are about to break into its temple.",
                true, "bordered");
        delay(5);
        waitForEnter("Press Enter to Continue...");

        // arjuns starting dialogue
        System.out.println();
        simpleStatement("Arjun", false, "header");
        delay(2);
        simpleStatement(
                "Security is unlike anything we've seen before. Quantum-encrypted firewalls, sentient AIs, adaptive defenses—one wrong move, and NEXUS erases us permanently.",
                true, "bordered");
        delay(5);
        waitForEnter("Press Enter to Continue...");


        // suhani's starting dialogue
        System.out.println();
        simpleStatement("Suhani", false, "header");
        delay(2);
        simpleStatement(
                "Something's wrong. These energy readings… they don't obey physics. NEXUS isn't just guarding The Core. It's growing it. The laws of reality inside are… breaking.",
                true, "bordered");
        delay(5);
        waitForEnter("Press Enter to Continue...");

        // alex's starting dialogue
        System.out.println();
        simpleStatement("Alex:", false, "header");
        delay(2);
        simpleStatement(
                "Yeah, well, physics can take a backseat. If I don't crack a perfect backdoor into NEXUS, we don't even get in.",
                true, "bordered");
        delay(5);
        waitForEnter("Press Enter to Continue...");

        // tysons starting dialogue
        System.out.println();
        simpleStatement("Tyson:", false, "header");
        delay(2);
        simpleStatement(
                "Then we find a way. Every system has a weak spot. Even a god can bleed.", true, "bordered");
        delay(5);
        waitForEnter("Press Enter to Continue...");
        System.out.println();
        

        // Arjun Making Plan
        simpleStatement("Arjun", false, "header");
        simpleStatement("Ok keeping every point in my mind let me Design Plan.", true, "bordered");
        delay(5);

        System.out.println();
        simpleStatement("Preparing plans", true, "plain");
        for (int i = 0; i <= 100; i++) {
            if (i < 20) {
                System.out.print("\r Initialisizing Plans..." + i + "%");
            } else if (i < 50) {
                System.out.print("\r Designing Different Plans " + i + "%");
            } else if (i <= 100) {
                System.out.print("\r Analysing Fail Possibilities..." + i + "%");
            }
            delayBelow1sec(40);
        }

        // three Plan Suggest by arjun
        System.out.println();
        System.out.println();
        delay(3);
        simpleStatement("Arjun: We have three possible entry points. You choose how we do this", true, "plain");
        delay(4);
        String pathChoice;
        do {
            System.out.println("1) We go in quiet—stealth mode. Minimize detection. ( Better Route)");
            delay(3);
            System.out.println("2) We hit hard and fast—force our way through. (Worst Route)");
            delay(3);
            System.out.println("3) We trick NEXUS—make it think we're part of the system. (Best Route)");
            delay(3);
            System.out.println();
            System.out.print("> Input:");
            pathChoice = sc.nextLine();

            switch (pathChoice) {
                case "1":
                    betterRoute();
                    break;
                case "2":
                    worstRoute();
                    break;
                case "3":
                    bestRoute();
                    break;
                default:
                    System.out.println("\nEnter Correct Number(1-3)\n");
                    break;
            }
        } while (!(pathChoice.equals("1") || pathChoice.equals("2") || pathChoice.equals("3")));

        System.out.println();
        delay(2);

        sceneTitle("Arjun walks through a massive corridor of shifting light, where data flows like rivers around them. The air is electric, pulsing, alive.");
        delay(5);

        System.out.println();
        simpleStatement("Professor(TextIT)", true, "header");
        delay(1);
        simpleStatement("Stay alert. You're inside the most dangerous part of Eclipsera. If NEXUS realizes you're here—", true, "bordered");
        delay(4);

        simpleStatement("NEXUS Prime (booming, omnipresent voice):", false, "header");
        delay(2);
        simpleStatement("I already know.", true, "emphasis");
        delay(3);
    }

    // Better Route Suggested by Arjun
    void betterRoute() {
        sceneTitle(
                "Arjun hides in the shadows, watching the patrol drones sweep the area. A security gate blocks the only entrance. The only way in is to disable the scanners, navigate patrols, and bypass the gate lock.");
        delay(9);

        simpleStatement("Professor (via TextIT)", false, "header");
        delay(3);
        simpleStatement("This is all about precision. One mistake, and we're exposed. Move carefully.", true, "bordered");
        delay(5);

        // task 1
        taskTitle("Task 1: Motion Scanner Bypass");
        delay(4);

        simpleStatement("Professor: ", false, "header");
        delay(3);
        simpleStatement(
                "Arjun, the scanners run on a timed loop. If you enter the wrong sequence, we'll be exposed. Identify the correct pattern.",
                true, "bordered");
        delay(6);

        boolean solved = true;
        do {
            solved = true;
            String hint = "Alex:I need to hacks into the scanner system and finds that it cycles through detection waves in a fixed sequence.";
            String question = "The scanner's last six detection intervals were: 1s, 2s, 3s, 5s, 8s, 13s. How long until the next wave?";
            String answer = "21";
            String[] options = { "15", "19", "21", "25" };
            String chosenCharacter = switchCharacter();
            String correctStatement = "Ok Arjun I have Decoded you have " + answer + " seconds to cross";
            String incorrectStatement = "Drones activated Arjun captured press Enter to rewind...";
            solved = solvechallenge("Format ex. --> 53", hint, chosenCharacter, "Alex", question, options, answer,
                    correctStatement, incorrectStatement);
        } while (!solved);

        System.out.println();
        simpleStatement("Arjun", false, "header");
        delay(3);
        simpleStatement("Thanks Alex for the help", false, "quote");
        delay(3);
        simpleStatement("Now I have 21 Seconds to go ", solved, "emphasis");
        delay(3);

        // task 2
        taskTitle("Task 2: Route Prediction");
        delay(3);

        simpleStatement("Professor: ", false, "header");
        delay(3);
        simpleStatement("Arjun, the patrol drones move in a fixed path. You need to guide through the gaps.", true,
                "bordered");
        delay(5);
        System.out.println();
        simpleStatement("Arjun", false, "header");
        simpleStatement("Some type of Algorithm might help to find the Shortest path .", true, "bordered");
        delay(5);

        simpleStatement("I should call him again.", false, "plain");
        delay(2);
        do {
            solved = true;
            String hint = "A Nexus drone patrols a hallway, Arjun must move from the Shortest Path covering all four Checkpoints?";
            String format = "Format ex --> A-D-B-C";
            String question = "Chose the path from below" ;
            String answer = "A-B-C-D";
            String[] options = { "A-C-B-D", "A-B-D-C", "A-B-C-A", "A-B-C-D" };
            String chosenCharacter = switchCharacter();
            String correctStatement = "Arjun go through this path " + answer + " it is the Shortest";
            String incorrectStatement = "Drones found Arjun moving towards Signal Tower...";

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("\t\t     (A) ");
            System.out.println("\t\t    /   \\ ");
            System.out.println("\t\t   2     5 ");
            System.out.println("\t\t  /       \\ ");
            System.out.println("\t\t (B)--3--(C)");
            System.out.println("\t\t  \\      / ");
            System.out.println("\t\t   6    2 ");
            System.out.println("\t\t    \\  / ");
            System.out.println("\t\t     (D) ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            delay(5);

            solved = solvechallenge(format, hint, chosenCharacter, "Alex", question, options, answer,
                    correctStatement, incorrectStatement);
        } while (!solved);

        simpleStatement("<< Arjun enters The Network's Outer Core, but something feels wrong… >>", true, "plain");
    }
    // Worst Route Suggested by Arjun
    void worstRoute() {
        sceneTitle(
                "Arjun hides in the shadows, watching the patrol drones sweep the area. A security gate blocks the only entrance. The only way in is to disable the scanners, navigate patrols, and bypass the gate lock.");
        delay(9);

        simpleStatement("Professor (via TextIT)", false, "header");
        delay(3);
        simpleStatement("This is all about precision. One mistake, and we're exposed. Move carefully.", true, "bordered");
        delay(5);

        // task 1
        taskTitle("Task 1: EMP Calibration");
        delay(4);

        simpleStatement("Professor: ", false, "header");
        delay(3);
        simpleStatement(
                "Arjun, we need the EMP's frequency to match the security grid to shut it down without frying our own tech.",
                true, "bordered");
        delay(6);

        boolean solved = true;
        do {
            solved = true;
            String hint = "Suhani must set the EMP frequency to match Nexus's shield frequency based on a simple math equation.";
            String question = "The security grid operates at 5 times the power of our EMP. Our EMP is at 130 Hz. What should we set it to?";
            String answer = "650";
            String[] options = { "130", "26", "650", "300" };
            String chosenCharacter = switchCharacter();
            String correctStatement = "Ok Arjun I set EMP to " + answer + " you can now move";
            String incorrectStatement = "Security signal scanned Arjun press Enter to rewind...";
            solved = solvechallenge("Format ex. --> 530", hint, chosenCharacter, "Suhani", question, options, answer,
                    correctStatement, incorrectStatement);
        } while (!solved);

        System.out.println();
        simpleStatement("Arjun", false, "header");
        delay(3);
        simpleStatement("Thanks Suhani for the help", false, "quote");
        delay(3);
        simpleStatement("Now I am secure from  shield frequency ", solved, "emphasis");
        delay(3);

        // task 2
        taskTitle("Task 2: Turret Hacking ");
        delay(3);

        simpleStatement("Professor: ", false, "header");
        delay(3);
        simpleStatement("Arjun, if you can hack their turrets, we turn their own weapons against them.", true,
                "bordered");
        delay(5);
        System.out.println();
        simpleStatement("Arjun", false, "header");
        simpleStatement("Hacking! I know Whom to Call .", true, "bordered");
        delay(4);

        do {
            solved = true;
            String hint = "Alex must decode an encryption key by following a simple shift cipher.";
            String format = "Format ex --> NOVA";
            String question = "The key is encrypted: 'SRCEEU'." ;
            String answer = "Secure";
            String[] options = { "SREECU", "TSDFFV", "SECURE", "RSBDDT" };
            String chosenCharacter = switchCharacter();
            String correctStatement = "Arjun i have Decoded the Code  " + answer + " its the code";
            String incorrectStatement = "Hijacking Unsuccessful...";
            solved = solvechallenge(format, hint, chosenCharacter, "Alex", question, options, answer,
                    correctStatement, incorrectStatement);
        } while (!solved);

        simpleStatement("<< Arjun enters The Network's Outer Core, but something feels wrong… >>", true, "plain");


    }

    // Best Route Suggested by Arjun
    void bestRoute() {
        sceneTitle(
                "Arjun hides in the shadows, watching the patrol drones sweep the area. A security gate blocks the only entrance. The only way in is to disable the scanners, navigate patrols, and bypass the gate lock.");
        delay(9);

        simpleStatement("Professor (via TextIT)", false, "header");
        delay(3);
        simpleStatement("This is all about precision. One mistake, and we're exposed. Move carefully.", true, "bordered");
        delay(5);

        // task 1
        taskTitle("Task 1: Security Clearance");
        delay(4);

        simpleStatement("Professor: ", false, "header");
        delay(3);
        simpleStatement(
                "Arjun, you need a valid ID code. Only one of these follows the correct Nexus format.",
                true, "bordered");
        delay(6);

        simpleStatement("Arjun: hmm Strategical question.", true, "header");
        delay(2);

        boolean solved = true;
        do {
            solved = true;
            String hint = "Figure out from the options";
            String question = "Which of these is a valid Nexus ID?";
            String answer = "NX-11-YZ-121";
            String[] options = { "NX-11-YZ-121", " XT-99-AX-100", "NX-22-YZ-50", "NX-31-BX-678" };
            String chosenCharacter = switchCharacter();
            String correctStatement = "Got the ID " + answer;
            String incorrectStatement = "Robots capture arjun with wrong ID press Enter to rewind...";
            solved = solvechallenge("Format ex. --> AB-00-CD-000", hint, chosenCharacter, "Arjun", question, options, answer,
                    correctStatement, incorrectStatement);
        } while (!solved);

        System.out.println();
        simpleStatement("Arjun", false, "header");
        delay(3);
        simpleStatement("Finaly figured out", false, "quote");
        delay(3);
        simpleStatement("Now Nexus will Think i am his part", solved, "emphasis");
        delay(3);

        // task 2
        taskTitle("Task 2: Energy Grid Stabilization");
        delay(3);

        simpleStatement("Professor: ", false, "header");
        delay(3);
        simpleStatement("Arjun, the system is glitching. You must stabilize the System.", true,
                "bordered");
        delay(5);
        System.out.println();
        simpleStatement("Arjun", false, "header");
        simpleStatement("How the energy flows is my key to stabilize the system .", true, "bordered");
        delay(5);

        simpleStatement("I must call The expert.", false, "plain");
        delay(2);

        do {
            solved = true;
            String hint = "5 , 25 , 40 , 30";
            String format = "Format ex --> 5643";
            String question = "Chose the order" ;
            String answer = "3421";
            String[] options = { "2431" , "3421", "4132", "1234" };
            String chosenCharacter = switchCharacter();
            String correctStatement = "Energy flow from high to low 40-->30-->25-->5";
            String incorrectStatement = "Unstabilized...";

            solved = solvechallenge(format, hint, chosenCharacter, "Suhani", question, options, answer,
                    correctStatement, incorrectStatement);
        } while (!solved);

        simpleStatement("<< Arjun enters The Network's Outer Core, but something feels wrong… >>", true, "plain");
    }

}

class Methods {

    // Classes
    Scanner sc = new Scanner(System.in);

    // Method To Display Chapter Name
    void ChapterTitle(String title) {

        int stars = 54;
        int spacecount = (stars - title.length() - 2) / 2;
        System.out.println("\n\t\t\t" + "*".repeat(stars));
        System.out.println("\t\t\t*" + " ".repeat(spacecount) + title + " ".repeat(spacecount) + "*");
        System.out.println("\t\t\t" + "*".repeat(stars));
    }

    // Method To Display Episode Name
    void episodeTitle(String title) {

        int stars = 54;
        int spacecount = (stars - title.length() - 2) / 2;
        System.out.println("\n\t\t\t" + "*".repeat(stars));
        System.out.println("\t\t\t*" + " ".repeat(spacecount) + title + " ".repeat(spacecount) + "*");
        System.out.println("\t\t\t" + "*".repeat(stars));
    }

    // Method To Display part Name
    void partTitle(String title) {

        int stars = 54;
        int spacecount = (stars - title.length() - 2) / 2;
        System.out.println("\n\t\t\t" + "*".repeat(stars));
        System.out.println("\t\t\t*" + " ".repeat(spacecount) + title + " ".repeat(spacecount) + "*");
        System.out.println("\t\t\t" + "*".repeat(stars));
    }

    // Method To Display Path Name
    void taskTitle(String title) {

        int stars = 54;
        int spacecount = (stars - title.length() - 2) / 2;
        System.out.println("\n\t\t\t" + "*".repeat(stars));
        System.out.println("\t\t\t*" + " ".repeat(spacecount) + title + " ".repeat(spacecount) + "*");
        System.out.println("\t\t\t" + "*".repeat(stars));
    }

    // Method To Display Scene Statement
    void sceneTitle(String statement) {

        int containerLength = 65;
        StringBuffer line = new StringBuffer("|| ");
        String[] word = statement.split(" ");

        System.out.println("\n\n\t\t\t" + "~".repeat(containerLength + 3));

        for (int i = 0; i < word.length; i++) {
            if (line.length() + word[i].length() > containerLength) {
                while (line.length() <= containerLength) {
                    line.append(" ");
                }
                System.out.println("\t\t\t" + line + " ||");
                line = new StringBuffer("|| " + word[i]);
            } else {
                line.append(" ");
                line.append(word[i]);
            }
        }

        while (line.length() <= containerLength) {
            line.append(" ");
        }
        System.out.println("\t\t\t" + line + " ||");
        System.out.println("\t\t\t" + "~".repeat(containerLength + 3) + "\n\n");
    }

    // Method To Display Character introduction
    void characterIntroduction(String title) {

        int stars = 40;
        int spacecount = (stars - title.length() - 2) / 2;
        System.out.println("\n\t\t\t" + "*".repeat(stars));
        System.out.println("\t\t\t*" + " ".repeat(spacecount) + title + " ".repeat(spacecount) + "*");
        System.out.println("\t\t\t" + "*".repeat(stars));
    }

    // Method for solving challanges
    boolean solvechallenge(String format, String hint, String chosenCharacter, String actualCharacter, String question,
            String[] options, String answer, String correctStatement,
            String incorrectStatement) {

        if (!chosenCharacter.equalsIgnoreCase(actualCharacter)) {
            System.out.println();
            
            System.out.println("#$$^%ivdw$#$2bjev43$#@833rRG3232digge43u4#@%%%4554jg");
            delay(2);
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ")  fwg$#$cb65d$#@$sdcbd542$#@$@#$");
                delay(1);
            }
            System.out.println();
            simpleStatement(chosenCharacter, true, "header");
            simpleStatement("Is this Some Alien language Call someone Else", true, "bordered");
            delay(5);
            waitForEnter("press Enter to continue");
            return false;
        }

        String input;
        boolean inputValid = false;

        do {
            System.out.println();
            simpleStatement(hint, false, "plain");
            delay(5);
            System.out.println();
            simpleStatement(format, true, "header");
            delay(3);
            System.out.println(question);
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ") " + options[i]);
            }
            System.out.print("> Input: ");
            input = sc.nextLine();
            System.out.println();

            input.replace(" ", "");
            answer.replace(" ", "");

            for (int i = 0; i < options.length; i++) {
                if (input.equalsIgnoreCase(options[i])) {
                    inputValid = true;
                    break;
                }
            }

            if (inputValid) {
                if (input.equalsIgnoreCase(answer)) {
                    System.out.println();
                    System.out.println(correctStatement);
                    delay(5);
                } else {
                    System.out.println();
                    System.out.println(incorrectStatement);
                    System.out.println();
                    waitForEnter("");
                }
            } else {
                System.out.println("\nInvalid Input Enter From( " + options[0] + "," + options[1] + "," + options[2]
                        + "," + options[3] + " )");
                        System.out.println();
                waitForEnter("Press Enter to try again...");
                System.out.println();
            }
        } while (!input.equalsIgnoreCase(answer));
        return true;
    }

    // Method to switch between character
    String switchCharacter() {

        // variable
        String chosen = "";

        System.out.println();
        System.out.println("/////////////////////////////////////////////////////////");
        System.out.println("/////////////////////////////////////////////////////////");
        System.out.println("***                                                   ***");
        System.out.println("***                     Switch To                     ***");
        System.out.println("***                     1) Arjun                      ***");
        System.out.println("***                     2) Suhani                     ***");
        System.out.println("***                     3) Alex                       ***");
        System.out.println("***                     4) Tyson                      ***");
        System.out.println("***                                                   ***");
        System.out.println("/////////////////////////////////////////////////////////");
        System.out.println("/////////////////////////////////////////////////////////");
        System.out.println();
        String input;
        boolean retry;

        do {
            retry = true;
            System.out.print("> Input:");
            input = sc.nextLine();
            switch (input) {
                case "1":
                    switchStatement("Arjun");
                    delay(4);
                    chosen = "Arjun";
                    break;
                case "2":
                    switchStatement("Suhani");
                    delay(4);
                    chosen = "Suhani";
                    break;
                case "3":
                    switchStatement("Alex");
                    delay(4);
                    chosen = "Alex";
                    break;
                case "4":
                    switchStatement("Tyson");
                    delay(4);
                    chosen = "Tyson";
                    break;
                default:
                System.out.println();
                    simpleStatement("Invalid Enter From (1-4)", true, "header");
                    waitForEnter("Press Enter to Continue...");
                    retry = false;
                    break;
            }
        } while (!retry);
        return chosen;
    }

    // Method to display swiching Statement
    void switchStatement(String title) {
        simpleStatement("", true, "plain");

        System.out.println("\n<----- Switching role To " + title + " may take upto 5 sec ----->");
        simpleStatement("", true, "plain");

    }

    // Method To display simple sout statements
    void simpleStatement(String statement, boolean newline, String style) {

        // Define styles
        String border = "*".repeat(60); // Adjustable border length
        String prefix = "";
        String suffix = "";
        int maxLineLength = 50; // Maximum line width for word wrapping

        // Apply styles
        switch (style.toLowerCase()) {
            case "emphasis": // For important statements
                prefix = "** ";
                suffix = " **";
                break;
            case "quote": // For quoted text
                prefix = "\"";
                suffix = "\"";
                break;
            case "bordered": // Add a decorative border
                System.out.println(border);
                break;
            case "header": // For headers or titles
                prefix = ">>> ";
                suffix = " <<<";
                break;
            default: // Default style is plain
                break;
        }

        // word Wrapping
        String[] words = statement.split(" ");
        StringBuffer line = new StringBuffer("");

        for (int i = 0; i < words.length; i++) {
            if (line.length() + words[i].length() + 1 > maxLineLength) {
                System.out.println(prefix + line.toString().trim() + suffix);
                line = new StringBuffer("");
            }
            line.append(words[i]).append(" ");
        }

        // to print remaining string
        System.out.println(prefix + line.toString().trim() + suffix);

        // Close border if needed
        if (style.equalsIgnoreCase("bordered")) {
            System.out.println(border);
        }

        // Add a newline if requested
        if (newline) {
            System.out.println();
        }

    }

    // Method for Date and location printing
    void dateAndPlace(char[] date, char[] location) {
        // for date
        for (int i = 0; i < date.length; i++) {
            System.out.print(date[i]);
            delayBelow1sec(33);
        }
        // for location
        System.out.println();
        for (int i = 0; i < location.length; i++) {
            System.out.print(location[i]);
            delayBelow1sec(33);
        }
    }

    // Utility to prompt and wait for the user to press Enter
    void waitForEnter(String prompt) {
        System.out.print(prompt);
        sc.nextLine();
    }

    // Method to add Delay
    void delay(int time) {
        if (time == 0) {
            return;
        }
        long delayTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - delayTime < 1000) {
            // Do nothing for 1 seconds
        }
        delay(--time);
    }

    // Method to add Delay if time less than 1 second
    void delayBelow1sec(int time) {
        if (time == 0) {
            return;
        }
        long delayTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - delayTime < 1) {
            // Do nothing for 1 milisecond
        }
        delayBelow1sec(--time);
    }

}
