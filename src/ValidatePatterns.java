/**
 * @author Jamie Hernandez
 * @version 2/25/2020
 */
public class ValidatePatterns
{
    /**
     * Write a recursive method that checks if the given string is a valid java identifier:
     *      must start with a letter,
     *      the subsequent characters must be letters or digits
     *      the length of a valid identifier must be at least one
     */
    private static boolean isIdentifier(String str)
    {
        //TODO Project #2a - DONE
        // utilize String methods like: length, substring and charAt
        // utilize Character.isLetter and Character.isLetterOrDigit
        int size = str.length();
        char ch;
        boolean isId = false;

        if (str.isEmpty()){
            isId = false;
        }else {
            ch = str.charAt(size - 1);
            if (size == 1){
                isId = Character.isLetter(ch);
            }else if (Character.isLetterOrDigit(ch)){
                isId = isIdentifier(str.substring(0, size - 1));
            }
        }
        return isId; //THIS IS A STUB
    }


    /**
     * Write a recursive method that validates if the given string is a valid word in the following pattern:
     *    the characters must be dots or dashes
     *    only the following patterns are allowed:
     *    word -> dash
     *            OR dot followed by word
     *            OR word followed by dash
     */
    private static boolean isDashDotCode(String str)
    {
        //TODO Project #2b - DONE
        // utilize String methods like substring and charAt
        boolean isDashOrDot = false;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='-'){
                isDashOrDot=true;
            }
            else if(str.charAt(i)=='.' && isDashOrDot){return false;}
            else if(str.charAt(i)!='.' && str.charAt(i)!='.'){return false;}
        }

        if(!isDashOrDot){return false;}

        return true; // THIS IS A STUB
    }

    public static void main(String[] args)
    {
        String toCheck = "AB5";
        System.out.println("Is \"" + toCheck + "\" a valid identifier ? --> "
                + (isIdentifier(toCheck) ? "YES" : "NO"));
        toCheck = "A?B5";
        System.out.println("Is \"" + toCheck + "\" a valid identifier ? --> "
                + (isIdentifier(toCheck) ? "YES" : "NO"));
        toCheck = "5AB5";
        System.out.println("Is \"" + toCheck + "\" a valid identifier ? --> "
                + (isIdentifier(toCheck) ? "YES" : "NO"));
        toCheck = "ABcdefg";
        System.out.println("Is \"" + toCheck + "\" a valid identifier ? --> "
                + (isIdentifier(toCheck) ? "YES" : "NO"));
        toCheck = "12345A";
        System.out.println("Is \"" + toCheck + "\" a valid identifier ? --> "
                + (isIdentifier(toCheck) ? "YES" : "NO"));
        toCheck = "A12345";
        System.out.println("Is \"" + toCheck + "\" a valid identifier ? --> "
                + (isIdentifier(toCheck) ? "YES" : "NO"));
        toCheck = "";
        System.out.println("Is \"" + toCheck + "\" a valid identifier ? --> "
                + (isIdentifier(toCheck) ? "YES" : "NO"));

        System.out.println();
        toCheck = "---";
        System.out.println("Is \"" + toCheck + "\" a valid DashDot code ? --> "
                + (isDashDotCode(toCheck) ? "YES" : "NO"));
        toCheck = ".--";
        System.out.println("Is \"" + toCheck + "\" a valid DashDot code ? --> "
                + (isDashDotCode(toCheck) ? "YES" : "NO"));
        toCheck = "..-";
        System.out.println("Is \"" + toCheck + "\" a valid DashDot code ? --> "
                + (isDashDotCode(toCheck) ? "YES" : "NO"));
        toCheck = "--.";
        System.out.println("Is \"" + toCheck + "\" a valid DashDot code ? --> "
                + (isDashDotCode(toCheck) ? "YES" : "NO"));
        toCheck = "-.-";
        System.out.println("Is \"" + toCheck + "\" a valid DashDot code ? --> "
                + (isDashDotCode(toCheck) ? "YES" : "NO"));

        toCheck = "-..";
        System.out.println("Is \"" + toCheck + "\" a valid DashDot code ? --> "
                + (isDashDotCode(toCheck) ? "YES" : "NO"));
        toCheck = ".-.";
        System.out.println("Is \"" + toCheck + "\" a valid DashDot code ? --> "
                + (isDashDotCode(toCheck) ? "YES" : "NO"));
        toCheck = "...";
        System.out.println("Is \"" + toCheck + "\" a valid DashDot code ? --> "
                + (isDashDotCode(toCheck) ? "YES" : "NO"));
        toCheck = "+..";
        System.out.println("Is \"" + toCheck + "\" a valid DashDot code ? --> "
                + (isDashDotCode(toCheck) ? "YES" : "NO"));
        toCheck = ".-.-";
        System.out.println("Is \"" + toCheck + "\" a valid DashDot code ? --> "
                + (isDashDotCode(toCheck) ? "YES" : "NO"));
        toCheck = "..--";
        System.out.println("Is \"" + toCheck + "\" a valid DashDot code ? --> "
                + (isDashDotCode(toCheck) ? "YES" : "NO"));
        toCheck = "-";
        System.out.println("Is \"" + toCheck + "\" a valid DashDot code ? --> "
                + (isDashDotCode(toCheck) ? "YES" : "NO"));
        toCheck = ".";
        System.out.println("Is \"" + toCheck + "\" a valid DashDot code ? --> "
                + (isDashDotCode(toCheck) ? "YES" : "NO"));
        toCheck = "...----";
        System.out.println("Is \"" + toCheck + "\" a valid DashDot code ? --> "
                + (isDashDotCode(toCheck) ? "YES" : "NO"));
        toCheck = "";
        System.out.println("Is \"" + toCheck + "\" a valid DashDot code ? --> "
                + (isDashDotCode(toCheck) ? "YES" : "NO"));
    }
}
