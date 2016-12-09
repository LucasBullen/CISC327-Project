>| MAF.txt
>| VAL.txt

for i in `seq 1 1`;
do
    TS1="day"$i"TS1.txt"
    TS2="day"$i"TS2.txt"
    TS3="day"$i"TS3.txt"

    echo "Day "$i

    # ./Daily.sh VAL day1TS1.txt  day1TS2.txt day1TS3.txt MAF.txt nMAF.txt nVAL.txt
    ./Daily.sh VAL $TS1 $TS2 $TS3 MAF.txt nMAF${i}.txt nVAL${i}.txt TSF${i}.txt

    #cp nMAF${i}.txt MAF.txt
    #cp nVAL${i}.txt VAL
done
