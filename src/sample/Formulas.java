package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Formulas {
        public static TextField savings(TextField txtPrincipal, TextField txtInterest, TextField txtTime, TextField txtFutureVal) {
            double periods = 12;
            double principle;
            double interestRate;
            double time;
            double futureValue;
            ArrayList<TextField> savingsInputFields = new ArrayList<TextField>();
            ArrayList<TextField> RemovingEmptyFields = new ArrayList<TextField>();
            ArrayList<TextField> finalValues = new ArrayList<TextField>();
            savingsInputFields.add(txtPrincipal);
            savingsInputFields.add(txtInterest);
            savingsInputFields.add(txtTime);
            savingsInputFields.add(txtFutureVal);

            savingsInputFields.forEach(savinginputfields -> {
                if (savinginputfields.getText().trim().isEmpty()) {
                    RemovingEmptyFields.add(savinginputfields);
                } else if (!(savinginputfields.getText().isEmpty())) {
                    finalValues.add(savinginputfields);
                }
            });
            try {
                if (finalValues.size() == 4) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("The value that needs to be calculated should be empty!");
                    alert.show();
                } else if (RemovingEmptyFields.size() <= 4 && RemovingEmptyFields.size() > 1) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("The value that needs to be calculated should only be the one that's empty!");
                    alert.show();
                } else if (RemovingEmptyFields.size() == 1 && RemovingEmptyFields.get(0) == txtFutureVal) {
                    principle = Double.parseDouble(txtPrincipal.getText());
                    interestRate = Double.parseDouble(txtInterest.getText()) / 100;
                    time = Double.parseDouble(txtTime.getText());

                    futureValue = principle * (Math.pow((1 + (interestRate / periods)), (periods * time)));
                    txtFutureVal.setText(String.valueOf(Math.round(futureValue * 100.0) / 100.0));
                    Alert alert = new Alert (Alert.AlertType.INFORMATION);
                    alert.setContentText("Summary \n Principal Amount : "+ txtPrincipal.getText()+"£\nInterest Rate        : "+txtInterest.getText()+"%\nTime In Months       : "+txtTime.getText()+" Months\nFuture Value        : "+"£ "+txtFutureVal.getText());
                    alert.show();
                    return txtFutureVal;

                } else if (RemovingEmptyFields.size() == 1 && RemovingEmptyFields.get(0) == txtInterest) {
                    principle = Double.parseDouble(txtPrincipal.getText());
                    futureValue = Double.parseDouble(txtFutureVal.getText());
                    time = Double.parseDouble(txtTime.getText());

                    interestRate = periods * ((Math.pow((futureValue / principle), (1 / (periods * time)))) - 1);
                    txtInterest.setText(String.valueOf(Math.round(interestRate * 100 * 100) / 100.0));
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Summary \n Principal Amount : "+ txtPrincipal.getText()+"£\nInterest Rate        : "+txtInterest.getText()+"%\nTime In Years       : "+txtTime.getText()+" months\nFuture Value        : "+"£ "+txtFutureVal.getText());
                    alert.show();
                    return txtInterest;

                } else if (RemovingEmptyFields.size() == 1 && RemovingEmptyFields.get(0) == txtPrincipal) {
                    interestRate = Double.parseDouble(txtInterest.getText()) / 100;
                    futureValue = Double.parseDouble(txtFutureVal.getText());
                    time = Double.parseDouble(txtTime.getText());

                    principle = futureValue / (Math.pow((1 + (interestRate / periods)), periods * time));
                    txtPrincipal.setText(String.valueOf(Math.round(principle * 100.0) / 100.0));
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Summary ");
                    alert.setContentText(" Principal Amount : £ "+ txtPrincipal.getText()+"\nInterest Rate        : "+txtInterest.getText()+"%\nTime In Months       : "+txtTime.getText()+" months\nFuture Value        : "+"£ "+txtFutureVal.getText());
                    alert.show();
                    return txtPrincipal;

                } else if (RemovingEmptyFields.size() == 1 && RemovingEmptyFields.get(0) == txtTime) {
                    principle = Double.parseDouble(txtPrincipal.getText());
                    interestRate = Double.parseDouble(txtInterest.getText()) / 100;
                    futureValue = Double.parseDouble(txtFutureVal.getText());

                    time = (Math.log(futureValue / principle)) / (periods * (Math.log(1 + (interestRate / periods))));
                    txtTime.setText(String.valueOf(Math.round(time * 100.0) / 100.0));
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Summary ");
                    alert.setContentText("Principal Amount : £ "+ txtPrincipal.getText()+"\nInterest Rate        : "+txtInterest.getText()+"%\nTime In Months       : "+txtTime.getText()+" months\nFuture Value        : "+"£ "+txtFutureVal.getText());
                    alert.show();
                    return txtTime;
                }
            } catch (Exception exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please enter only numerical values!");
                alert.show();
            }

            return txtPrincipal;
        }
        public static TextField compound(TextField txtFutureVal, TextField txtInterest, TextField txtPrinciple,TextField txtMonthlyPay,TextField txtTime ) {
            double principle;
            double interestRate;
            double time;
            double periods = 12;
            double futureValue;
            double monthlyPay;
            ArrayList<TextField> txtfields = new ArrayList<TextField>();
            ArrayList<TextField> RemovingEmptyFields = new ArrayList<TextField>();
            ArrayList<TextField> finalValues = new ArrayList<TextField>();
            txtfields.add(txtFutureVal);
            txtfields.add(txtInterest);
            txtfields.add(txtPrinciple);
            txtfields.add(txtMonthlyPay);
            txtfields.add(txtTime);

            txtfields.forEach(textField -> {
                if (textField.getText().trim().isEmpty()) {
                    RemovingEmptyFields.add(textField);
                } else if (!(textField.getText().isEmpty())) {
                    finalValues.add(textField);
                }
            });
            try {
                if (finalValues.size() == 5) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("The value that needs to be calculated should be empty!");
                    alert.show();
                } else if (RemovingEmptyFields.size() <= 5 && RemovingEmptyFields.size() > 1) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("The value that needs to be calculated should only be the one that's empty!");
                    alert.show();
                } else if (RemovingEmptyFields.size() == 1 && RemovingEmptyFields.get(0) == txtFutureVal) {
                    principle = Double.parseDouble(txtPrinciple.getText());
                    monthlyPay=Double.parseDouble(txtMonthlyPay.getText());
                    interestRate = Double.parseDouble(txtInterest.getText()) / 100;
                    time = Double.parseDouble(txtTime.getText());


                    futureValue = principle * Math.pow ((1+(interestRate/periods)),(periods*time)) + monthlyPay * ((Math.pow((1+(interestRate/periods)),(interestRate*periods))-1)/(interestRate/periods));
                    txtFutureVal.setText(String.valueOf(Math.round(futureValue * 100.0) / 100.0));
                    Alert alert = new Alert (Alert.AlertType.INFORMATION);
                    alert.setTitle("Summary");
                    alert.setContentText("Future Value        : "+"£ "+txtFutureVal.getText()+"\nInterest Rate        : "+txtInterest.getText()+"%\nPrincipal Amount : £ " + txtPrinciple.getText()+"\nMonthly Payment: £ "+txtMonthlyPay.getText()+"\nTime In Months       : "+txtTime.getText()+" months");
                    alert.show();
                    return txtFutureVal;

                    //FileOperations.write("savingsTempData", futureValue, presentValue, interestRate, timeInYears);
                    //System.out.println(FileOperations.read("savingsTempData"));

                } else if (RemovingEmptyFields.size() == 1 && RemovingEmptyFields.get(0) == txtMonthlyPay) {
                    principle = Double.parseDouble(txtPrinciple.getText());
                    futureValue = Double.parseDouble(txtFutureVal.getText());
                    time = Double.parseDouble(txtTime.getText());
                    interestRate = Double.parseDouble(txtInterest.getText()) / 100;

                    monthlyPay = (futureValue-principle*(Math.pow((1+(interestRate/periods)),(periods*time))))/((Math.pow((1+(interestRate/periods)),(periods*time))-1)/(interestRate/periods));
                    txtMonthlyPay.setText(String.valueOf(Math.round(monthlyPay * 100 ) / 100.0));
                    Alert alert = new Alert (Alert.AlertType.INFORMATION);
                    alert.setTitle("Summary");
                    alert.setContentText("Future Value        : "+"£ "+txtFutureVal.getText()+"\nInterest Rate        : "+txtInterest.getText()+"%\nPrincipal Amount : £ "+txtPrinciple.getText()+"\nMonthly Payment: £ "+txtMonthlyPay.getText()+" \nTime In Months       : "+txtTime.getText()+" months");
                    alert.show();
                    return txtMonthlyPay;


                } else if (RemovingEmptyFields.size() == 1 && RemovingEmptyFields.get(0) == txtPrinciple) {
                    interestRate = Double.parseDouble(txtInterest.getText()) / 100;
                    futureValue = Double.parseDouble(txtFutureVal.getText());
                    time = Double.parseDouble(txtTime.getText());
                    monthlyPay=Double.parseDouble(txtMonthlyPay.getText());

                    principle = (futureValue - (monthlyPay * ((Math.pow((1 + (interestRate/periods)), periods * time) - 1) / (interestRate/periods))))/ ( periods * time);
                    txtPrinciple.setText(String.valueOf(Math.round(principle * 100.0) / 100.0));
                    Alert alert = new Alert (Alert.AlertType.INFORMATION);
                    alert.setTitle("Summary");
                    alert.setContentText("Future Value        : "+"£ "+txtFutureVal.getText()+"\nInterest Rate        : "+txtInterest.getText()+"%\nPrincipal Amount : £ "+txtPrinciple.getText()+"\nMonthly Payment: £ "+txtMonthlyPay.getText()+"\nTime In Months       : "+txtTime.getText()+" months");
                    alert.show();
                    return txtPrinciple;

                } else if (RemovingEmptyFields.size() == 1 && RemovingEmptyFields.get(0) == txtTime) {
                    principle = Double.parseDouble(txtPrinciple.getText());
                    interestRate = Double.parseDouble(txtInterest.getText()) / 100;
                    futureValue = Double.parseDouble(txtFutureVal.getText());
                    monthlyPay=Double.parseDouble(txtMonthlyPay.getText());


                    time = Math.log(((((interestRate * futureValue) / periods) + monthlyPay) / (((principle * interestRate) / periods) + monthlyPay))) / (periods * Math.log(1 + (interestRate/periods)));
                    txtTime.setText(String.valueOf(Math.round(time)));
                    Alert alert = new Alert (Alert.AlertType.INFORMATION);
                    alert.setTitle("Summary");
                    alert.setContentText("Future Value        : "+"£ "+txtFutureVal.getText()+"\nInterest Rate        : "+txtInterest.getText()+"%\nPrincipal Amount : "+txtPrinciple.getText()+"£\nMonthly Payment: "+txtMonthlyPay.getText()+"\nTime In Months       : "+txtTime.getText()+" months");
                    alert.show();
                    return txtTime;
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please enter only numerical values!");
                alert.show();
            }

            return txtPrinciple;
        }
        public static TextField mortgage(TextField txtHomePrice, TextField txtDownPay, TextField txtLoanTerm,TextField txtInterest,TextField txtMonthlyPay ) {
            double homePrice;
            double downPay;
            double time;
            double periods = 12;
            double interestRate;
            double monthlyPay;

            ArrayList<TextField> txtfields = new ArrayList<TextField>();
            ArrayList<TextField> RemovingEmptyFields = new ArrayList<TextField>();
            ArrayList<TextField> finalValues = new ArrayList<TextField>();
            txtfields.add(txtHomePrice);
            txtfields.add(txtDownPay);
            txtfields.add(txtLoanTerm);
            txtfields.add(txtInterest);
            txtfields.add(txtMonthlyPay);

            txtfields.forEach(fields -> {
                if (fields.getText().trim().isEmpty()) {
                    RemovingEmptyFields.add(fields);
                } else if (!(fields.getText().isEmpty())) {
                    finalValues.add(fields);
                }
            });
            try {
                if (finalValues.size() == 5) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("The value that needs to be calculated should be empty!");
                    alert.show();
                } else if (RemovingEmptyFields.size() <= 5 && RemovingEmptyFields.size() > 1) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("The value that needs to be calculated should only be the one that's empty!");
                    alert.show();
                } else if (RemovingEmptyFields.size() == 1 && RemovingEmptyFields.get(0) == txtHomePrice) {
                    downPay = Double.parseDouble(txtDownPay.getText());
                    monthlyPay=Double.parseDouble(txtMonthlyPay.getText());
                    interestRate = Double.parseDouble(txtInterest.getText()) / 100;
                    time = Double.parseDouble(txtLoanTerm.getText());

                    homePrice = downPay + ((periods * monthlyPay * (Math.pow((1 + (interestRate / periods)), (periods * time)) - 1)) / (interestRate * Math.pow((1 + (interestRate / periods)), (periods * time))));
                    txtHomePrice.setText(String.valueOf(Math.round(homePrice * 100.0) / 100.0));
                    Alert alert = new Alert (Alert.AlertType.INFORMATION);
                    alert.setTitle("Summary");
                    alert.setContentText("Home Value          : "+"£ "+txtHomePrice.getText()+"\nInterest Rate          : "+txtInterest.getText()+"%\nMonthly Addition  : "+txtMonthlyPay.getText()+"£\nDown Payment      : "+txtDownPay.getText()+"£\nLoan Term             : "+txtLoanTerm.getText()+" months");
                    alert.show();
                    return txtHomePrice;

                    //FileOperations.write("savingsTempData", futureValue, presentValue, interestRate, timeInYears);
                    //System.out.println(FileOperations.read("savingsTempData"));

                } else if (RemovingEmptyFields.size() == 1 && RemovingEmptyFields.get(0) == txtMonthlyPay) {
                    downPay = Double.parseDouble(txtDownPay.getText());
                    homePrice = Double.parseDouble(txtHomePrice.getText());
                    interestRate = Double.parseDouble(txtInterest.getText()) / 100;
                    time = Double.parseDouble(txtLoanTerm.getText());



                    monthlyPay = ((homePrice - downPay) * (interestRate / periods) * Math.pow((1 + (interestRate / periods)), periods * time)) / (Math.pow((1 + (interestRate / periods)), periods * time) - 1);
                    txtMonthlyPay.setText(String.valueOf(Math.round(monthlyPay * 100 ) / 100.0));
                    Alert alert = new Alert (Alert.AlertType.INFORMATION);
                    alert.setTitle("Summary");
                    alert.setContentText("Home Price          : "+txtHomePrice.getText()+"£\nInterest Rate          : "+txtInterest.getText()+"%\nMonthly Addition  : "+txtMonthlyPay.getText()+"£\nDown Payment      : "+txtDownPay.getText()+"£\nLoan Term             : "+txtLoanTerm.getText()+" months");
                    alert.show();
                    return txtMonthlyPay;


                } else if (RemovingEmptyFields.size() == 1 && RemovingEmptyFields.get(0) == txtLoanTerm) {
                    downPay = Double.parseDouble(txtDownPay.getText());
                    monthlyPay=Double.parseDouble(txtMonthlyPay.getText());
                    homePrice = Double.parseDouble(txtHomePrice.getText());
                    interestRate = Double.parseDouble(txtInterest.getText()) / 100;



                    time = (Math.log((monthlyPay / (monthlyPay - ((interestRate/periods) * (homePrice - downPay)))))) /  (periods * Math.log(1 + (interestRate/periods)));
                    txtLoanTerm.setText(String.valueOf(Math.round(time * 100.0) / 100.0));
                    Alert alert = new Alert (Alert.AlertType.INFORMATION);
                    alert.setTitle("Summary");
                    alert.setContentText("Home Value          : "+txtHomePrice.getText()+"£\nInterest Rate          : "+txtInterest.getText()+"%\nMonthly Addition  : "+txtMonthlyPay.getText()+"£\nDown Payment      : "+txtDownPay.getText()+"£\nLoan Term             : "+txtLoanTerm.getText()+" months");
                    alert.show();
                    return txtLoanTerm;

                } else if (RemovingEmptyFields.size() == 1 && RemovingEmptyFields.get(0) == txtDownPay) {
                    monthlyPay=Double.parseDouble(txtMonthlyPay.getText());
                    homePrice = Double.parseDouble(txtHomePrice.getText());
                    interestRate = Double.parseDouble(txtInterest.getText()) / 100;
                    time = Double.parseDouble(txtLoanTerm.getText());

                    downPay = homePrice - ((periods * monthlyPay * (Math.pow((1 + (interestRate / periods)), periods * time) - 1)) / (interestRate * Math.pow((1 + (interestRate / periods)), periods * time)));
                    txtDownPay.setText(String.valueOf(Math.round(downPay * 100.0) / 100.0));
                    Alert alert = new Alert (Alert.AlertType.INFORMATION);
                    alert.setTitle("Summary");
                    alert.setContentText("Home Value          : "+txtHomePrice.getText()+"$\nInterest Rate          : "+txtInterest.getText()+"%\nMonthly Addition  : "+txtMonthlyPay.getText()+"£\nDown Payment      : "+txtDownPay.getText()+"£\nLoan Term             : "+txtLoanTerm.getText()+" months");
                    return txtDownPay;
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please enter only numerical values!");
            }

            return txtHomePrice;
        }
        public static TextField loan(TextField txtLoan, TextField txtInterest, TextField txtLoanTerm,TextField txtMonthlyPay) {
            double loan;
            double interestRate;
            double time;
            double monthlyPay;

            ArrayList<TextField> txtfields = new ArrayList<TextField>();
            ArrayList<TextField> RemovingEmptyFields = new ArrayList<TextField>();
            ArrayList<TextField> finalValues = new ArrayList<TextField>();
            txtfields.add(txtLoanTerm);
            txtfields.add(txtInterest);
            txtfields.add(txtLoanTerm);
            txtfields.add(txtMonthlyPay);

            txtfields.forEach(fields -> {
                if (fields.getText().trim().isEmpty()) {
                    RemovingEmptyFields.add(fields);
                } else if (!(fields.getText().isEmpty())) {
                    finalValues.add(fields);
                }
            });
            try {
                if (finalValues.size() == 4) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("The value that needs to be calculated should be empty!");
                    alert.show();
                } else if (RemovingEmptyFields.size() <= 4 && RemovingEmptyFields.size() > 1) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("The value that needs to be calculated should only be the one that's empty!");
                    alert.show();
                } else if (RemovingEmptyFields.size() == 1 && RemovingEmptyFields.get(0) == txtLoanTerm) {
                    monthlyPay=Double.parseDouble(txtMonthlyPay.getText());
                    interestRate = Double.parseDouble(txtInterest.getText()) / 100;
                    time = Double.parseDouble(txtLoanTerm.getText());

                    loan =  (monthlyPay / interestRate) * (1 - (1 / Math.pow((1 + interestRate), time)));
                    txtLoan.setText(String.valueOf(Math.round(loan * 100.0) / 100.0));
                    Alert alert = new Alert (Alert.AlertType.INFORMATION);
                    alert.setTitle("Summary");
                    alert.setContentText("Loan Amount               : "+txtLoanTerm.getText()+"£\nMonthly Interest Rate  : "+txtInterest.getText()+"%\nMonthly Payment         : "+txtMonthlyPay.getText()+"£\nLoan Term                    : "+txtLoanTerm.getText()+" months");
                    alert.show();
                    return txtLoanTerm;

                    //FileOperations.write("savingsTempData", futureValue, presentValue, interestRate, timeInYears);
                    //System.out.println(FileOperations.read("savingsTempData"));

                } else if (RemovingEmptyFields.size() == 1 && RemovingEmptyFields.get(0) == txtMonthlyPay) {
                    interestRate = Double.parseDouble(txtInterest.getText()) / 100;
                    time = Double.parseDouble(txtLoanTerm.getText());
                    loan = Double.parseDouble(txtLoan.getText());

                    monthlyPay = (loan * interestRate) / (1 - (1 / Math.pow((1 + interestRate), time)));
                    txtMonthlyPay.setText(String.valueOf(Math.round(monthlyPay * 100 ) / 100.0));
                    Alert alert = new Alert (Alert.AlertType.INFORMATION);
                    alert.setTitle("Summary");
                    alert.setContentText("Loan Amount               : "+txtLoanTerm.getText()+"£\nMonthly Interest Rate  : "+txtInterest.getText()+"%\nMonthly Payment         : "+txtMonthlyPay.getText()+"£\nLoan Term                    : "+txtLoanTerm.getText()+" months");
                    alert.show();
                    return txtMonthlyPay;


                } else if (RemovingEmptyFields.size() == 1 && RemovingEmptyFields.get(0) == txtLoanTerm) {
                    monthlyPay=Double.parseDouble(txtMonthlyPay.getText());
                    interestRate = Double.parseDouble(txtInterest.getText()) / 100;
                    loan = Double.parseDouble(txtLoan.getText());

                    time = Math.log((monthlyPay / interestRate) / ((monthlyPay / interestRate) - loan)) / Math.log(1 + interestRate);
                    txtLoanTerm.setText(String.valueOf(Math.round(time * 100.0) / 100.0));
                    Alert alert = new Alert (Alert.AlertType.INFORMATION);
                    alert.setTitle("Summary");
                    alert.setContentText("Loan Amount               : "+txtLoanTerm.getText()+"£\nMonthly Interest Rate  : "+txtInterest.getText()+"%\nMonthly Payment         : "+txtMonthlyPay.getText()+"£\nLoan Term                    : "+txtLoanTerm.getText()+" months");
                    alert.show();
                    return txtLoanTerm;


                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please enter only numerical values!");
                alert.show();
            }

            return txtLoanTerm;
        }
    }

