# first phase-Gator Translator
	Malayalam<->English
		a single word translations.
		if a word does not exist then return that error to the user.
		
# TODO
	How best to implement a one-one mapping of words storage? HashMap or Set? Set would be better since it can reduce the complications
	of duplicates! But is it costly? yes.
	Static Storage of 100-1000 words mapping? will it grow? yes! Read a File or Store Statically?
	
# Dictionary Class
	enum type of malayalam or english.
	based on that look up different sets.
	
# Limitations
	Only can translate one word at a time.
