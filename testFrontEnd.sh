# TODO: direct to main directory
cd input
for testTypeDir in *; do
	rm -r ../failedTests/$testTypeDir/*
	cd $testTypeDir
	for inputFile in *; do
		#output creating
		echo "running test $inputFile"
		cd ../../frontEnd
		java Main accounts TSF < ../input/$testTypeDir/$inputFile > ../output/$testTypeDir/${inputFile:0:${#inputFile} - 6}Out.txt
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