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
		    java Main accountsEmpty ${inputFile:0:${#inputFile} - 6}TSF < ../input/$testTypeDir/$inputFile > ../output/$testTypeDir/${inputFile:0:${#inputFile} - 6}Out.txt
		else
			java Main accounts ${inputFile:0:${#inputFile} - 6}TSF < ../input/$testTypeDir/$inputFile > ../output/$testTypeDir/${inputFile:0:${#inputFile} - 6}Out.txt
		fi
		if [ -f ${inputFile:0:${#inputFile} - 6}TSF.txt ] ; then
			cp ${inputFile:0:${#inputFile} - 6}TSF*.txt ../TSF/$testTypeDir/
			rm ${inputFile:0:${#inputFile} - 6}TSF*.txt
			#output created
			#expected output comparing
			diff ../output/$testTypeDir/${inputFile:0:${#inputFile} - 6}Out.txt ../expectedOutput/$testTypeDir/${inputFile:0:${#inputFile} - 6}Out.txt > ../failedTests/$testTypeDir/${inputFile:0:${#inputFile} - 6}Out.txt

			cd ../TSF/$testTypeDir
			for TSF in *; do
				diff $TSF ../../expectedTSF/$testTypeDir/$TSF > ../../failedTests/$testTypeDir/${inputFile:0:${#inputFile} - 6}TSF.txt
			done

			cd ../../failedTests/$testTypeDir
		else
			cd ../failedTests/$testTypeDir
		fi

		find . -size 0 -delete

		#expected output comared
		cd ../../input/$testTypeDir
	done
	cd ../
done