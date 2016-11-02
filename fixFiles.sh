cd input
for testTypeDir in *; do
	cd $testTypeDir
	for inputFile in *.txt; do
		head -n -1 $inputFile
		echo "quit" >> $inputFile
		echo "" >> $inputFile
	done
	cd ../
done