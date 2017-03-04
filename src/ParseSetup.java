import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Invoked when the user clicks on one of the
 * menu radio buttons.  Checks each input for errors
 * and tokenizes them accordingly
 */

@SuppressWarnings("ResultOfMethodCallIgnored")
class ParseSetup {

    private final ResultsPanel rp;
    private final LabelPanel lp;
    private final TokenParser tp;
    private int successfulCount = 0;

    public ParseSetup(ResultsPanel rp, LabelPanel lp, TokenParser tp) {

        this.rp = rp;
        this.lp = lp;
        this.tp = tp;
    }

    public void setSuccessfulCount() {
        successfulCount = 0;
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private void fail() {
        lp.getL1().setText("Bad Format! : (");
        lp.getL2().setText(".......");
        lp.getL3().setText(".......");
        lp.getL4().setText(".......");
        lp.getL5().setText(".......");
        tp.getTextPane().setText("");
    }

    public void clear() {
        lp.getL1().setText("");
        lp.getL2().setText(".......");
        lp.getL3().setText(".......");
        lp.getL4().setText(".......");
        lp.getL5().setText(".......");
        rp.getTextArea().setText("");
    }

    /**
     * If the user clicks on the IP button
     */
    public void parsedIP() {

        //Creating an array list of tokens
        String s = tp.getText();
        StringTokenizer st = new StringTokenizer(s, ".");
        ArrayList<String> IPPart = new ArrayList<>();
        int countTokens = st.countTokens();

        for (int i = 0; i < countTokens; i++) {
            IPPart.add(st.nextToken());
        }

        //Error Checking
        for (int i = 0; i < IPPart.size(); i++) {
            if (isInteger(IPPart.get(i))) {
                countTokens = 0;
                break;
            }
            if (i == 0) {
                if (IPPart.get(i).length() != 3) {
                    countTokens = 0;
                    break;
                }
            } else if (i > 0) {
                if (IPPart.get(1).length() < 1 || IPPart.get(1).length() > 3) {
                    countTokens = 0;
                    break;
                }
            }
        }

        if (countTokens == 3) {
            lp.getL1().setText("Properly Parsed! : )");
            lp.getL2().setText(IPPart.get(0));
            lp.getL3().setText(IPPart.get(1));
            lp.getL4().setText(IPPart.get(2));
            lp.getL5().setText(".......");
            tp.getTextPane().setText("");

            if (successfulCount != 0) {
                rp.getTextArea().append("\n" + s + " : ["
                        + IPPart.get(0) + ", "
                        + IPPart.get(1) + ", "
                        + IPPart.get(2)
                        + "]");
            } else {
                rp.getTextArea().setText(s + " : ["
                        + IPPart.get(0) + ", "
                        + IPPart.get(1) + ", "
                        + IPPart.get(2)
                        + "]");
                successfulCount++;
            }
        } else if (countTokens == 4) {
            lp.getL1().setText("Properly Parsed! : )");
            lp.getL2().setText(IPPart.get(0));
            lp.getL3().setText(IPPart.get(1));
            lp.getL4().setText(IPPart.get(2));
            lp.getL5().setText(IPPart.get(3));
            tp.getTextPane().setText("");

            if (successfulCount != 0) {
                rp.getTextArea().append("\n" + s + " : ["
                        + IPPart.get(0) + ", "
                        + IPPart.get(1) + ", "
                        + IPPart.get(2) + ", "
                        + IPPart.get(3)
                        + "]");
            } else {
                rp.getTextArea().setText(s + " : ["
                        + IPPart.get(0) + ", "
                        + IPPart.get(1) + ", "
                        + IPPart.get(2) + ", "
                        + IPPart.get(3)
                        + "]");
                successfulCount++;
            }
        } else {
            fail();
        }

    }

    /**
     * If the user clicks on the Email button
     */
    public void parsedEmail() {

        String s = tp.getText();
        StringTokenizer st = new StringTokenizer(s, "@.");
        ArrayList<String> EmailPart = new ArrayList<>();
        int countTokens = st.countTokens();

        for (int i = 0; i < countTokens; i++) {
            EmailPart.add(st.nextToken());
        }

        if (countTokens == 3) {

            tp.getTextPane().setText("");
            lp.getL1().setText("Properly Parsed! : )");
            lp.getL2().setText(EmailPart.get(0));
            lp.getL3().setText(EmailPart.get(1));
            lp.getL4().setText(EmailPart.get(2));
            lp.getL5().setText(".......");
            tp.getTextPane().setText("");

            if (successfulCount != 0) {
                rp.getTextArea().append("\n" + s + " : ["
                        + EmailPart.get(0) + ", "
                        + EmailPart.get(1) + ", "
                        + EmailPart.get(2)
                        + "]");
                successfulCount++;
            } else {
                rp.getTextArea().setText(s + " : ["
                        + EmailPart.get(0) + ", "
                        + EmailPart.get(1) + ", "
                        + EmailPart.get(2)
                        + "]");
                successfulCount++;
            }
        } else {
            fail();
        }

    }

    /**
     * If the user clicks on the Phone Number button
     */
    public void parsedPhone() {

        String s = tp.getText();

        char parenthCheck = '(';
        if (s.charAt(0) == parenthCheck) {

            StringTokenizer st = new StringTokenizer(s, "()-");
            ArrayList<String> PhonePart = new ArrayList<>();

            int countTokens = st.countTokens();

            for (int i = 0; i < countTokens; i++) {
                PhonePart.add(st.nextToken());
            }

            for (int i = 0; i < PhonePart.size(); i++) {
                if (isInteger(PhonePart.get(i))) {
                    countTokens = 0;
                    break;
                } else if (i == 0 || i == 1) {
                    if (PhonePart.get(i).length() < 3 || PhonePart.get(i).length() > 3) {
                        countTokens = 0;
                        break;
                    }
                } else if (i == 2) {
                    if (PhonePart.get(i).length() != 4) {
                        countTokens = 0;
                        break;
                    }
                }
            }

            if (countTokens == 3) {
                tp.getTextPane().setText("");
                lp.getL1().setText("Properly Parsed! : )");
                lp.getL2().setText(PhonePart.get(0));
                lp.getL3().setText(PhonePart.get(1));
                lp.getL4().setText(PhonePart.get(2));
                lp.getL5().setText(".......");
                tp.getTextPane().setText("");

                if (successfulCount != 0) {
                    rp.getTextArea().append("\n" + s + " : ["
                            + PhonePart.get(0) + ", "
                            + PhonePart.get(1) + ", "
                            + PhonePart.get(2)
                            + "]");
                } else {
                    rp.getTextArea().setText(s + " : ["
                            + PhonePart.get(0) + ", "
                            + PhonePart.get(1) + ", "
                            + PhonePart.get(2)
                            + "]");
                    successfulCount++;
                }
            } else {
                fail();
            }
        } else {
            fail();
        }
    }

    /**
     * If the user clicks on the Credit Card button
     */
    public void parsedCredit() {

        String s = tp.getText();
        StringTokenizer st = new StringTokenizer(s, " ");
        ArrayList<String> CreditPart = new ArrayList<>();

        int countTokens = st.countTokens();

        for (int i = 0; i < countTokens; i++) {
            CreditPart.add(st.nextToken());
        }

        for (String aCreditPart : CreditPart) {
            if (isInteger(aCreditPart)) {
                countTokens = 0;
                break;
            } else if (aCreditPart.length() != 4) {
                countTokens = 0;
                break;
            }
        }

        if (countTokens == 4) {
            lp.getL1().setText("Properly Parsed! : )");
            lp.getL2().setText(CreditPart.get(0));
            lp.getL3().setText(CreditPart.get(1));
            lp.getL4().setText(CreditPart.get(2));
            lp.getL5().setText(CreditPart.get(3));
            tp.getTextPane().setText("");

            if (successfulCount != 0) {
                rp.getTextArea().append("\n" + s + " : ["
                        + CreditPart.get(0) + ", "
                        + CreditPart.get(1) + ", "
                        + CreditPart.get(2) + ", "
                        + CreditPart.get(3)
                        + "]");
            } else {
                rp.getTextArea().setText(s + " : ["
                        + CreditPart.get(0) + ", "
                        + CreditPart.get(1) + ", "
                        + CreditPart.get(2) + ", "
                        + CreditPart.get(3)
                        + "]");
                successfulCount++;
            }
        } else {
            fail();
        }
    }
}
