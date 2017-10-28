/**
 * Class  Counts.
 * <p>
 * class for demonstration of multithreading.
 *
 *
 * @author vryazanov
 * @version 1.0
 * @since 02.04.2017
 */
public class Counts {
    /**
     * Store string to analyze.
     */
    public static final String STRING = "The Roman Empire had a huge task in front of them while it was first starting out and while it was becoming a dominant dynasty in the early civilizations. The main problem that the book «Discovering the Global Past» points out is how the Roman Empire found itself growing a little too quickly. The Roman Empire started out very small on the Tiber River and grew abruptly without warning. Before they knew it, they were not a small power but now one with a great number of people with a great number of cultures intertwined within the Roman Empire. They were now spread over an immense portion of land with much power coming with it. The question now is how they are going to be able to handle all of this power and continue to dominate the world without any blueprints to help them out from previous dynasties because it had never been done before. We now have some evidence to help understand this and to show how it did happen. So courtesy of the «Discovering the Global Past» they have seven pieces of evidence that will help prove that the Roman Empire could handle the challenge of taking on the mastery of world power. The first piece of evidence that I have is The Achievements of the Divine Augustus, which states all of the achievements and accomplishments that helped him conquer the world under the Roman Empire. In this piece of evidence it shows all of Caesar Augustus’ tactics he used to help him conquer the world. Many of which were war related. He gained most of his power by going to war and overthrowing that particular ruler. Thus this helped him gain respect which was also a key factor in his dominance. Once gaining the respect of the Roman Senate and also the republic he became the top runner to be «elected sole guardian of the laws and moral with supreme authority». But Augustus refused to take that role of leadership in the Empire. He did many things in which the people love such as repairing the capitol and the theater of Pompey which cost a great amount and he did it without any public recognition. He did a number of things to help out the ruins and made the cities better by rebuilding them and making them nice again. Also what he wasn’t going to finish by his death he would make sure his heirs would complete it. This list goes on and on of things that Augustus had done to help out the lives of people under the Roman Empire. This piece of evidence showed the strength that Roman Empire would soon have because they were still on the rise. The second piece of evidence that I have is Powers and Titles of the Emperor. This was a key part of having a successful empire. Once the Roman Empire was established they thought up a hierarchy to help control the empire. The good thing that came out of this was that the senate and the republic agreed to pass all the power entirely to Augustus. Now that they had a good ruler, it showed that their empire was growing and was a very strong for to be reckoned with. With such a high status Augustus and his successors expected a lot of support from the people and from the Roman senate. The third piece of evidence that was available was the Roman Coin of the Reign of Emperor Nero. This was a coin that was minted during the Emperor Nero which had his portrait on it along with his name, his relationship to Caesar Augustus, and the four most prized titles that he had been awarded. They do this to help show and advertise their public image. But this wasn’t the only way that Emperor’s helped their public image and helps make them well known. They would make statues of themselves like the one the Emperor Trajan had made which is our fourth piece of evidence called Trajan’s Column, which was located in Rome. This was made with him in a military outfit to show that he was a military commander. According to Discovering The Global Past, it had to say this about Trajan’s Column: «Although built primarily to hold aloft a huge statue of Trajan in military dress, the column also publicizes his most famous campaign, a war fought against the Dacians on the Balkan peninsula». So this went to show that they would build statues and make coins to make themselves they would also use them as campaigns to help recruit and make wars successful which is key to build up an empire. Now leading us to our sixth piece of evidence the Roman Temple Inscription in Myra, Lycia, which was the inscription that Caesar Augustus had written on the wall. They do this to show the emperor’s divine status while in rule. This was a trend that was just beginning which helped sort out whom they were and whom they wanted to be remembered as by letting them write this in their own words for all the people to see. The last piece of evidence is the Edict and Speech of Nero to the Greeks, which is the speech where the Emperor Nero gives the Greek people a reward for good will and not out of pity on the people. This is exactly how an emperor can make the people happy by giving them rewards. When trying to control a whole nation one must try to make the people happy and this was a key thing to do to help the reign of the Roman Empire continue. In conclusion I found it quite remarkable how the Roman Empire had redefined political authority to suit a new level of world mastery. The main question that we had was how was the Roman Empire going to continue to be successful while it was on the rise so fast? Well the answer is quite easy and that is by using tactics that had never been used before which we found out were very successful. The Roman Empire was good to its people which made it possible for them to stay under control of the current emperor. For an emperor to go out rebuild cities and start new cities for people to live in was amazing, and that is how these great officials were elected by both the senate and the republic which was the backbone of the Roman Empire. Now it is considered one of the greatest empires ever.";
    /**
     * Store string to analyze.
     */
    public static final long TIMELIMIT = 10;
    /**
     * Store wordCounter.
     */
    public static int wordCounter = 0;
    /**
     * Store dashCounter.
     */
    public static int dashCounter = 0;
    /**
     * Store string with letters.
     */
    public static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Class  CountWords.
     * <p>
     * couts words in string.
     *
     */
    public static final class CountWords implements Runnable {
        public void run() {
            boolean isWord = false;
            for (Character c : STRING.toLowerCase().toCharArray()) {
                if (Thread.currentThread().isInterrupted()) {
                    return;
                }
                //если было не слово, а сейчас буквенный символ - началось слово
                if (!isWord && LETTERS.indexOf(c) != -1) {
                    System.out.println("Найдено новое слово, текущее количество: " + ++wordCounter);
                    isWord = true;
                }
                //если было слово, а сейчас небуквенный символ - значит слово закончилось, присваиваем isWord false
                if (isWord && LETTERS.indexOf(c) == -1) {
                    isWord = false;
                }
            }
        }
    }

    /**
     * Class  CountDashes.
     * <p>
     * couts dashes in string.
     *
     */
    public static final class CountDashes implements Runnable {
        public void run() {
            for (Character c : STRING.toLowerCase().toCharArray()) {
                if (Thread.currentThread().isInterrupted()) {
                    return;
                }
                if (c.equals(' ')) {
                    System.out.println("Найден новый пробел, текущее количество: " + ++dashCounter);
                }
            }

        }
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("The program starting...");
        Long startTime = System.currentTimeMillis();
        Thread threadWords = new Thread(new CountWords(), "countWords");
        Thread threadDashes = new Thread(new CountDashes(), "countDashes");
        threadWords.start();
        threadDashes.start();
        while ((System.currentTimeMillis() - startTime) <= TIMELIMIT && (threadWords.isAlive() || threadDashes.isAlive())) {
            int i = 1;
        }
        threadWords.interrupt();
        threadDashes.interrupt();
        System.out.println("Общее количество слов: " + wordCounter);
        System.out.println("Общее количество пробелов: " + dashCounter);
        System.out.println("The program has just finished");
    }
}
