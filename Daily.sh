# TODO: direct to main directory
VAL=$1
TS1=$2
TS2=$3
TS3=$4
MAF=$5
nMAF=$6
nVAL=$7
nTS=$8

mv ${VAL}.txt frontEnd/VAL.txt

cd frontEnd
echo quit >> ../${TS1}
java Main VAL TSF1 < ../${TS1}
sed '$d' < ../${TS1} > hold ; mv hold ../${TS1}

echo quit >> ../${TS2}
java Main VAL TSF2 < ../${TS2}
sed '$d' < ../${TS2} > hold ; mv hold ../${TS2}

echo quit >> ../${TS3}
java Main VAL TSF3 < ../${TS3}
sed '$d' < ../${TS3} > hold ; mv hold ../${TS3}

cd ../

mv frontEnd/TSF1.txt TSF1.txt
mv frontEnd/TSF2.txt TSF2.txt
mv frontEnd/TSF3.txt TSF3.txt
mv frontEnd/VAL.txt ${VAL}.txt


sed '$d' < TSF1.txt > hold ; mv hold TSF1.txt
cat TSF1.txt > TSF.txt
sed '$d' < TSF2.txt > hold ; mv hold TSF2.txt
cat TSF2.txt >> TSF.txt
cat TSF3.txt >> TSF.txt
cat TSF.txt >> $nTS

#back office

mv $MAF backEnd/MAF.txt
mv TSF.txt backEnd/TSF.txt

cd backEnd
java BackEnd MAF.txt TSF.txt nMAF.txt nVAL.txt
cd ../

mv backEnd/MAF.txt $MAF
mv backEnd/TSF.txt TSF.txt
mv backEnd/nMAF.txt $nMAF
mv backEnd/nVAL.txt $nVAL

rm VAL.txt
rm TSF.txt
rm TSF1.txt
rm TSF2.txt
rm TSF3.txt