# TODO: direct to main directory
cd input
for testTypeDir in *; do
	rm -r ../failedTests/$testTypeDir/*
	cd $testTypeDir
	for inputFile in *; do
		#output creating
		echo "running test $inputFile"
		cd ../../frontEnd
		if grep -Fxq "${inputFile:0:${#inputFile} - 6}" testWithEmptyAccounts.txt
		then
		    java Main accountsEmpty TSF < ../input/$testTypeDir/$inputFile > ../output/$testTypeDir/${inputFile:0:${#inputFile} - 6}Out.txt
		else
			java Main accounts TSF < ../input/$testTypeDir/$inputFile > ../output/$testTypeDir/${inputFile:0:${#inputFile} - 6}Out.txt
		fi
		#output created
		#expected output comparing
		diff ../output/$testTypeDir/${inputFile:0:${#inputFile} - 6}Out.txt ../expectedOutput/$testTypeDir/${inputFile:0:${#inputFile} - 6}Out.txt > ../failedTests/$testTypeDir/${inputFile:0:${#inputFile} - 6}Out.txt
		#diff ../outputs/$i.log ../expected/$i.log >
		cd ../failedTests/$testTypeDir
		find . -size 0 -delete
		#expected output comared
		cd ../../input/$testTypeDir
	done
	cd ../
done