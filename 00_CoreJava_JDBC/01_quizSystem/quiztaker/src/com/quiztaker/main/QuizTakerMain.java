// main class 
package com.quiztaker.main;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import com.quiztaker.main.controller.AdminController;
import com.quiztaker.main.controller.OptionController;
import com.quiztaker.main.controller.QuestionController;
import com.quiztaker.main.controller.QuizController;
import com.quiztaker.main.controller.SubjectController;
import com.quiztaker.main.controller.UserController;
import com.quiztaker.main.entity.Option;
import com.quiztaker.main.entity.Question;
import com.quiztaker.main.entity.Subject;
import com.quiztaker.main.entity.User;

public class QuizTakerMain {
	public static void main(String[] args) {
		// AdminController object
		AdminController adminController = new AdminController();
		
		// QuestionController object
		QuestionController questionController = new QuestionController();
					
		// UserController object
		UserController userController = new UserController();
		
		// QuizController object
		QuizController quizController = new QuizController();
		
		// SubjectController object
		SubjectController subjectController = new SubjectController();
//======ROUGH START

		
//======ROUGH END		
		
		// Scanner object for input
		Scanner sc = new Scanner(System.in);
		Scanner scForLine = new Scanner(System.in);
		
		System.out.println("Started...");
		System.out.println("================================================================================================\n");


		
		// used for running main loop
		Boolean doRunMainLoop=true;
		
		// main loop
		// menu driven
		do{
			System.out.println("📌 Main Menu : \n-----------------------------");
			System.out.println("Choose Option - \n 1.Admin Login \n 2.User Login \n 3.User SignUp \n 4.Exit");
			
			// asking user for option
			System.out.print("Option : ");

			int mainMenuChoice = sc.nextInt();
			
			System.out.println("==========================================");
			switch(mainMenuChoice) {
			case 1:// Admin Login
				System.out.println("👤 Admin Login : \n-----------------------------");
				System.out.print(" Enter Username : ");
				String adminUsername = sc.next();
				System.out.print(" Enter Password : ");
				String adminPassword = sc.next();
				
				// calling authAdmin method of AdminController
				Boolean isAdminAuthenticated = adminController.authAdmin(adminUsername,adminPassword);
				
				// checking and returning
				if(isAdminAuthenticated) {
					System.out.println("\n✅ Authenticated.\n");
					// used to run admin menu loop
					boolean doRunAdminLoop = true;
					
					// admin menus
					do{
						System.out.println("📌 Admin Panel\n-----------------------------");
						System.out.println("Choose Option - \n 1.Show All Subjects \n 2.Show All Questions \n 3.Add A Question With Options \n 4.Add A Subject \n 5.Logout");
						// asking admin for option
						System.out.print("Option : ");
						int adminMenuChoice = sc.nextInt();
						System.out.println("-----------------------------");
						switch(adminMenuChoice) {
						case 1://show all subjects
							System.out.println("\n📜 All Subjects : \n-----------------------------");
							
							// getting list of subjects along with keys
							LinkedHashMap<Integer, Subject> subjectsWithKeys = subjectController.getSubjectsWithKeys();
							
							// traverse subjectsWithKeys
							for(Entry<Integer, Subject> subject : subjectsWithKeys.entrySet()) {
								System.out.println("  "+subject.getKey()+"."+subject.getValue().getSubName());
							};
							
							System.out.println("\n------------------------------------------------------------------------------------------------\n");
							
							break;
						case 2: // Show All Questions
								System.out.println("\n📜 All Questions : \n-----------------------------");
								
								// calling getAllQuestionsWithOptions method of QuestionController
								LinkedHashMap<Question,List<Option>> allQuestionsWithOptions = questionController.getAllQuestionsWithOptions();
								
								// traverse allQuestionsWithOptions
								int srNoForQuestion=1;
								for(Entry<Question, List<Option>> entry : allQuestionsWithOptions.entrySet()) {
									// taking current key in a variable
									Question question = entry.getKey();
									System.out.println(srNoForQuestion+"] "+question.getQueStatement()+" ("+question.getQuePoints()+" Points)");
									
									// now for options
									char srNoForOption='a';// for bullating options
									// taking a correct option variable to store option with correct options
									Option correctOption = new Option();
									// need to traverse list of options
									List<Option> optionsList = entry.getValue();
									System.out.println("Options : ");
									for(Option option : optionsList) {
										System.out.println("\t"+srNoForOption+". "+option.getOptStatement());
										
										// if current option's isOptCorrect is true then assign this option in correctOption
										if(option.getIsOptCorrect()) {
											correctOption = option;
										}
										
										 srNoForOption++;// incrementing srNoOption for next option
									}
									
									// now print correct option
									System.out.println("Correct Option : "+correctOption.getOptStatement());
								
									// incrementing srNoForQuestion
									srNoForQuestion++;
									System.out.println("------------------------------------------------------------------------------------------------\n");
								}
								System.out.println("-------------------------------------------xxx--------------------------------------------------\n");
								break;
								
						case 3: // Add A Question
								// asking for which subject do you want to add question
								System.out.println("\n❓ Select Subject : \n-----------------------------");
								// getting list of subjects along with keys
								subjectsWithKeys = subjectController.getSubjectsWithKeys();
								
								// traverse subjectsWithKeys
								for(Entry<Integer, Subject> subject : subjectsWithKeys.entrySet()) {
									System.out.println("  "+subject.getKey()+"."+subject.getValue().getSubName());
								};
								System.out.print(" Option : ");
								int optionForSubject = sc.nextInt();
								
								
								System.out.println("\n➕ Add Question With Options : \n-----------------------------");
								// calling addQuestionWithOptions of QuestionController
								// asking admin to add question and optionsList
								// for Question
								Question question = new Question();
								System.out.println("✏️ Enter Question Details : \n");
								// asking details for question
							
								// question statement
								System.out.print(" Question Statement : ");
								String questionStatement = scForLine.nextLine();
								question.setQueStatement(questionStatement.trim());
								
								// question points
								System.out.print(" Question Points : ");
								Integer questionPoints = sc.nextInt();
								question.setQuePoints(questionPoints);
								
								// for Options
								// list to store multiple options
								ArrayList<Option> optionsList = new ArrayList<Option>();
								System.out.println("\n Enter Option Details : ");
								// asking user how many options he want to add
								System.out.print(" How Many Options You Want To Add? ");
								int optionsLimit = sc.nextInt();
								System.out.println();
								// loop to add optionsLimit options
								int le=1;// starting point
								while(le<=optionsLimit) {
									System.out.println(" For Option "+le+". :");
									// taking details for current le'th option
									Option option = new Option();
									
									// option statement
									System.out.print(" Option Statement : ");
									option.setOptStatement(scForLine.nextLine().trim());
									
									// isOptCorrent or not
									System.out.print(" Is Option Correct : 1.Yes  2.No : ");
									if(sc.nextInt() == 1) {
										option.setIsOptCorrect(true);
									}
									else {
										option.setIsOptCorrect(false);
									}
									
									// add le'th option in optionsList
									optionsList.add(option);
									
									// incrementing le
									le++;
								}
								
								// call to addQuestionWithOptions method of QuestionController
								String isQuestionAdded = questionController.addQuestionWithOptions(subjectsWithKeys.get(optionForSubject).getSubName(),question,optionsList);
								
								
								if(isQuestionAdded.equals("Question Not Saved.")) {
									System.out.println("\n❌ "+isQuestionAdded);
								}
								else {
									System.out.println("\n✅ "+isQuestionAdded);
								}
								
								System.out.println("\n-------------------------------------------xxx--------------------------------------------------\n");

							break;
							
						case 4:// add a subject
							System.out.println("\n➕ Add Subject Name : \n-----------------------------");
						
							// taking input for subject from user
							System.out.print("✏️ Enter Subject Name : ");
							String subjectName = sc.next().trim();
							
							// subject object 
							Subject subjectToAdd = new Subject();
							
							// setting subject value
							subjectToAdd.setSubName(subjectName);
							
							// calling addSubject method of SubjectController
							String isSubjectAdded = subjectController.addSubject(subjectToAdd);
							
							if(isSubjectAdded.equals("Subject Saved.")) {
								System.out.println("\n✅ "+isSubjectAdded);
							}
							else {
								System.out.println("\n❌ "+isSubjectAdded);
								
							}
							System.out.println("-----------------------------");
						break;
							
							
						case 5:// go to main menu
							System.out.println("\n⏏️ Logged Out.");
							System.out.println("↩️ Going to back menu...\n");
							doRunAdminLoop = false;
							break;
						default: System.out.println("Something Went Wrong In AdminMenu.");
						}
						
					}while(doRunAdminLoop);
					
					
				}
				else {
					System.out.println("\n🚫 Not Authenticated.");
				}
				
				
				break;
			case 2:// User Login
				System.out.println("👤 User Login : \n-----------------------------");
				System.out.print(" Enter EmailId : ");
				String userUsername = sc.next().trim();
				System.out.print(" Enter Password : ");
				String userPassword = sc.next().trim();
				
				// calling authUser method of UserController
				Boolean isUserAutheticated = userController.authUser(userUsername,userPassword);
				
				// checking and doing further operations
				if(isUserAutheticated) {
					System.out.println("\n✅ Authenticated.\n");
					
					// storing loggedInUser in a variable for further use
					User loggedInUser = userController.getUserByUsername(userUsername);

					// used to run user menu loop
					boolean doRunUserLoop = true;
					
					// user menus 
					do{
						System.out.println("📌 User Panel\n-----------------------------");
						System.out.println("Choose Option - \n 1.Show Profile \n 2.Take Quiz \n 3.Logout");
						// asking user for option
						System.out.print("Option : ");
						int userMenuChoice = sc.nextInt();
						System.out.println("-----------------------------");
						
						switch(userMenuChoice) {
						case 1:// show profile
							// calling getUserByUsername method of UserController
							userController.getUserByUsername(userUsername);
							break;
						case 2:// take quiz
							// ask user for subject of Quiz
							System.out.println("\n❓ Select Subject : \n-----------------------------");
							// getting list of subjects along with keys
							LinkedHashMap<Integer, Subject> subjectsWithKeys = subjectController.getSubjectsWithKeys();
							
							// traverse subjectsWithKeys
							for(Entry<Integer, Subject> subject : subjectsWithKeys.entrySet()) {
								System.out.println("  "+subject.getKey()+"."+subject.getValue().getSubName());
							};
							System.out.print(" Option : ");
							int optionForSubject = sc.nextInt();
							
						
							// call to takeQuiz method of QuizController
							quizController.takeQuiz(loggedInUser,subjectsWithKeys.get(optionForSubject));
							break;
						case 3:// logout user.. going to back menus
							System.out.println("\n⏏️ Logged Out.");
							System.out.println("↩️ Going to back menu...\n");
							doRunUserLoop=false;
							break;
						default:System.out.println("Something Went Wrong. Try Again.");
						}
						
					}while(doRunUserLoop);
					
					System.out.println("\n================================================================================================");

				}
				else {
					System.out.println("\n🚫 Not Authenticated.");
				}
				
				break;
			case 3:// User SignUp
				System.out.println("👤 User SignUp : \n-----------------------------");
				System.out.println(" Enter Details : ");
				System.out.print("  First Name : ");
				String userFName = sc.next().trim();
				System.out.print("  Last Name : ");
				String userLName = sc.next().trim();
				System.out.print("  Email Id : ");
				String userEmailId = sc.next().trim().toLowerCase();
				System.out.print("  Contact No. : ");
				String userContactNo = sc.next().trim();
				System.out.print("  Address : ");
				String userAddress = scForLine.nextLine().trim();
				System.out.print("  Password : ");
				String userPasswordToAdd = sc.next().trim();
				
				// creating object of User and setting entered values in User
				User userToAdd = new User();
				
				userToAdd.setUserFName(userFName);
				userToAdd.setUserLName(userLName);
				userToAdd.setUserEmailId(userEmailId);
				userToAdd.setUserContactNo(userContactNo);
				userToAdd.setUserAddress(userAddress);
				userToAdd.setUserPassword(userPasswordToAdd);
				
				// calling signUpUser method of UserController
				Boolean isUserSignedUp = userController.signUpUser(userToAdd);
				
				// checking and displaying
				if(isUserSignedUp) {
					System.out.println("\n✅ Sign Up Successfully. You Can Login.\n");
				}
				else {
					System.out.println("\n🚫 Error. Try Again\n");
				}
				break;
				
			case 4:// exit 
				System.out.println("-----------------------------\n     🙏 Thank You! 🙏\n Keep Growing and Keep Achieving!");
				doRunMainLoop=false;
				break;
			default:System.out.println("Something Went Wrong!");
			}
			System.out.println("-----------------------------\n");
		}while(doRunMainLoop);
		
		
		
		System.out.println("\n================================================================================================");
		System.out.println("Ended...");
	
	}
}
