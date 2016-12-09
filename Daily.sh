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
java Main VAL holdTSF1 < ../${TS1}
sed '$d' < ../${TS1} > hold ; mv hold ../${TS1}

echo quit >> ../${TS2}
java Main VAL holdTSF2 < ../${TS2}
sed '$d' < ../${TS2} > hold ; mv hold ../${TS2}

echo quit >> ../${TS3}
java Main VAL holdTSF3 < ../${TS3}
sed '$d' < ../${TS3} > hold ; mv hold ../${TS3}

cd ../

mv frontEnd/holdTSF1.txt holdTSF1.txt
mv frontEnd/holdTSF2.txt holdTSF2.txt
mv frontEnd/holdTSF3.txt holdTSF3.txt
mv frontEnd/VAL.txt ${VAL}.txt


sed '$d' < holdTSF1.txt > hold ; mv hold holdTSF1.txt
cat holdTSF1.txt > holdTSF.txt
sed '$d' < holdTSF2.txt > hold ; mv hold holdTSF2.txt
cat holdTSF2.txt >> holdTSF.txt
cat holdTSF3.txt >> holdTSF.txt
cp holdTSF.txt "${nTS}"

#back office

mv $MAF backEnd/MAF.txt
mv holdTSF.txt backEnd/TSF.txt

cd backEnd
java BackEnd MAF.txt TSF.txt nMAF.txt nVAL.txt
cd ../

mv backEnd/MAF.txt $MAF
mv backEnd/TSF.txt holdTSF.txt
mv backEnd/nMAF.txt $nMAF
mv backEnd/nVAL.txt $nVAL

rm holdTSF.txt
rm holdTSF1.txt
rm holdTSF2.txt
rm holdTSF3.txt