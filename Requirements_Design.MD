## Gator Translator
	Malayalam<->English
		a single word translations.
		if a word does not exist then return that error to the user.

# UI
	Currently only a normal view of taking in an input of one type of word namely english is supported.
	Want to enhance to provide a home screen with the options of MalayalamToEnglish or EnglishToMalayalam. How to do this?
		radio button may be?  yes went ahead and used radio button.		
		check box may be? no because radio buttons gave a more user friendly and understanble view.
		any other options? havent explored not necessary!
		
	Once above feature is implemented then based on that call the appropriate translator.
	
# Settings TODO
	Have an option to share the app.(share)
	Have an option to get information about the app.(about) Done
	Have an option to clear the input data on the edit box. (refresh) Done
	Have an option to check for updates. (Check for Updates)
	On the Display Message Activity have an option to report errors. Done
	
# Translation Logic
	How best to implement a one-one mapping of words storage? HashMap or Set? Set would be better since it can reduce the complications
	of duplicates! But then again Duplicates needs to be allowed since synonyms are possible. Done Using HashMap
	But is it costly? yes and performance isnt optimal.(Maybe a tree structure?)
	Static Storage of 100-1000 words mapping? will it grow? yes! 
	Read a File or Store Statically? Read file! Done
	Should all the data be loaded from the file at start up or look up as necessary? look up as necessary sounds like a better idea!
	 
# Translator Class
	enum type of malayalam or english. done
	based on that look up different data. 
	Method to read data from a file. done
	
# Miscellaneous TODO
	Utilize cache to see if you can look up a recently viewed word.
	
# Limitations
	Only can translate one phrase or a word at a time.
