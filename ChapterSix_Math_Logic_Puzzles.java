public class ChapterSix_Math_Logic_Puzzles {
    public static void main(){

    }
    public static void theHeavyPill(){
        //20 bottles of pills, 19 bottles have 1.0 gram pils, one has 1.1 gram pills
        //given an exact scale with a single use, find the heavy bottle
        //put 20, 19, 18, 17, 16.. and then find which one adds a certain amount of weight because the expected weight would be 20+19...+1 = 210
        //find which one adds a specific amount e.g. bottle 15 being the overweight one would make it 211.5
    }
    public static void basketball(){
        //Game 1: 1 shot to make hoop
        //Game 2: 3 shots, must make 2/3 
        /*
         * let p = probability of making a shopt
         * Game 1: probability = p of winning
         * Game 2: probability p (3 nCr 2) * p^3 + (3 ncR 3) * p^3
         * 3nCr2 = 3! / 2!(3-2)! = 3 
         * p^2 > 1/3
         * 3p^3 + p^3 > p : 4p^3 > p
         *  4p^2 > 1
         * p^2 > 1/4
         * p > 1/2 
         * p > 1/2 : play game 2
         * p < 1/2: play game 1
         * p = 1/2: play either game 
         */
    }
    public static void dominos(){
        //opposite corners cut off on 8x8 chess board
        //31 dominoes
        //possible to fill board?
        //my answer: no; it is not possible. Given that a domino must cover two adjacent squares, it is impossible to connect the two corners as they are not adjacent. 
        //textbook: domino must fill 1 black, 1 white square; with the corners being of the same color, we cannot fill 2 squares of the same color simultaneously.
    }
    public static void antsonaTriangle(){
        /* 
        3 ants on different vertices of triangle
        probability of collision (either 2 or all 3) if they start walking on the same? 
        same speed, equilaterial triangle, direction is 50/50.
        two ants can only collide if they are going in opposite directions, because one ant cannot just "catch up" to another ant 
        it should be impossible for all three ants to collide given they come at three different speeds 
        
        let's say they DONT collide:
        all three ants must go in the same direction:
        (1/2)* ( 1/2) * (1/2) * 2(because you can either go all left or all right)
        otherwise, they will collide inevitably. It's like getting all tails on a coin flip, or all heads. 
        collision = 3/4
        ^ YAY CORRECT

        for n sides, with n ants: 1-((1/2)^(n-1)) I TYPOED THIS AT FIRST AHFKLASHRKAHFKLASFJ BUT I SWEAR I GOT IT RIGHT I wrote 1-(2*(1/2)^(n-1)) because I didnt see my third (1/2) above ahfajksfbjsakfasj

        */
    }
    public static void jugsofWater(){
        /*
         * 5 qt jug, 3 qt jug, unlimited supply of water
         * How to get 4 qts. of water?
         * 
         * This one is quite simple. Fill 3 qt, fill 5 qt to 3 qts, fill 3 qt again, fill 5 qt to the top, and then dump out the contents of the 5qt. Fill the 5qt with the 1qrt left in the 3qt, and then refill 3qt and add it to the 5qt. 
         * 
         * Sorry if that was a poor explanation lol
         * 
         */
    }
    public static void blueEyedIsland(){
        //I'm so dumb for not getting this
        // if num = 1, he would just leave
        // if num = 2, they would know if there was only 1 person, they would have left already. they would leave on night 2
        // if num = 3, they would know if num = 2, they would have left on night 2...
        // therefore it would take c nights to leave
        //not a good question imo  
    }
    public static void theApocalypse(){
        /*
         *1 family: 
         * 1 girl: 1/2
         * 1 boy, 1 girl: 1/4
         * 2 boys, 1 girl: 1/8
         * 3 boys, 1 girl: 1/16
         * 4 boys, 1 girl: 1/25
         * Expected values: 
         * G: 1/2 + 1/4 + 1/8 + 1/16 + 1/25 for n = 5
         * B: 1/4 + 1/4 + 3/16 + 4/25 for n= 5
         * 
         * G: 1 girl
         * B: sum as n approaches infinity of n * 1 / (2^n+1) (which is 1)
         * Because expected value = probability * number = n * 1/(2^n+1) (+1 because of the 1 girl) 
         * 
         * Solution: Ratio is 50/50. 
         */

    }
    public static void eggdropProblem(){
        /*
         * 100 floor building
         * if an egg drops from floor N or above it cracks
         * given two eggs
         * 
         * My approach: binary search? 
         * Start at floor 50. If the egg drops, you are forced to start at 0. 
         * If the egg doesn't drop, go to 75. 
         * Surely that's the fastest way? 
         * WRONG AS FUCK MY BOY
         * 
         */
    }


}

