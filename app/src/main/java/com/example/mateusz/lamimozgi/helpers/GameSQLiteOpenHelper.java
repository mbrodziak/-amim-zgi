package com.example.mateusz.lamimozgi.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class GameSQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper{
    private static final String DB_NAME = "tasks_db.sqllite";
    private static final int VERSION = 1;
    public static final String STAGE_ID = "ID";
    public static final String STAGE_NAME = "name";
    public static final String STAGE = "stage";
    public static final String COMPLETE = "complete";
    public static final String STAGE_SAVE = "save";
    public static final String STAGE_EXTRA = "extra";
    public static final String STAGE_TYPE = "type";
    public static final String STAGE_WIDTH = "width";
    public static final String STAGE_HEIGHT = "height";

    public GameSQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
    }

    public void createTable(SQLiteDatabase db) {
        createTableSudoku(db);
        createTableCrossword(db);
        createTableWordSearch(db);
        createTableHangman(db);
        createTableGuessWork(db);
    }

    public void createTableGuessWork(SQLiteDatabase db) {
        db.execSQL("create table guessWork0 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table guessWork1 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table guessWork2 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("insert into guessWork0 (ID, name, stage, save, extra, complete) VALUES ('200','GUESS 1', 'Jak się nazywa płacz małego raczka?','','WYCIERACZKA','false');");
        db.execSQL("insert into guessWork0 (ID, name, stage, save, extra, complete) VALUES ('300','GUESS 2', 'Kto mówi wszystkimi językami świata?','','ECHO','false');");
        db.execSQL("insert into guessWork0 (ID, name, stage, save, extra, complete) VALUES ('400','GUESS 3', 'Papież tego nie używa, a mąż daje żonie?','','NAZWISKO','false');");

        db.execSQL("insert into guessWork1 (ID, name, stage, save, extra, complete) VALUES ('200','GUESS 1', 'Co biegnie w dół i w góre, ale się nie porusza?','','DROGA','false');");
        db.execSQL("insert into guessWork1 (ID, name, stage, save, extra, complete) VALUES ('300','GUESS 2', 'Co znika, jeśli wypowiesz tego nazwę?','','CISZA','false');");
        db.execSQL("insert into guessWork1 (ID, name, stage, save, extra, complete) VALUES ('400','GUESS 3', 'Miesiąc, w którym ludzie śpią najkrócej','','LUTY','false');");

        db.execSQL("insert into guessWork2 (ID, name, stage, save, extra, complete) VALUES ('200','GUESS 1', 'W pokoju było coś i nic. Coś wyszlo drzwiami, a nic oknem. Co zostało w pokoju?','','I','false');");
        db.execSQL("insert into guessWork2 (ID, name, stage, save, extra, complete) VALUES ('300','GUESS 2', 'Co ma miejsce raz w minucie, dwa razy w momencie i ani razu w ciągu tysiąca lat?','','M','false');");
        db.execSQL("insert into guessWork2 (ID, name, stage, save, extra, complete) VALUES ('400','GUESS 3', 'Czy to prawda, że jeżeli nie wiesz, że wiesz, to wiesz, że nie wiesz?','','PRAWDA','false');");
    }

    public void createTableHangman(SQLiteDatabase db) {
        db.execSQL("create table hangman0 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE_TYPE + " text, "+
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table hangman1 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE_TYPE + " text, "+
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table hangman2 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE_TYPE + " text, "+
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("insert into hangman0 (ID, name, type, stage, save, extra, complete) VALUES ('200','first hang','TELEWIZOR','---------','',0,'false');");
        db.execSQL("insert into hangman0 (ID, name, type, stage, save, extra, complete) VALUES ('300','second hang','INFORMATYKA','-----------','',0,'false');");
        db.execSQL("insert into hangman0 (ID, name, type, stage, save, extra, complete) VALUES ('400','third hang','HAWKEYE','-------','',0,'false');");

        db.execSQL("insert into hangman1 (ID, name, type, stage, save, extra, complete) VALUES ('200','first hang','METAMORFOZA','-----------','',0,'false');");
        db.execSQL("insert into hangman1 (ID, name, type, stage, save, extra, complete) VALUES ('300','second hang','ZWIERZCHNICTWO','--------------','',0,'false');");
        db.execSQL("insert into hangman1 (ID, name, type, stage, save, extra, complete) VALUES ('400','third hang','ONOMATOPEJA','-----------','',0,'false');");

        db.execSQL("insert into hangman2 (ID, name, type, stage, save, extra, complete) VALUES ('200','first hang','LUMPENPROLETARIAT','-----------------','',0,'false');");
        db.execSQL("insert into hangman2 (ID, name, type, stage, save, extra, complete) VALUES ('300','second hang','ANATOMOPATOLOGICZNY','-------------------','',0,'false');");
        db.execSQL("insert into hangman2 (ID, name, type, stage, save, extra, complete) VALUES ('400','third hang','DEOKSYRYBONUKLEINOWY','--------------------','',0,'false');");

    }

    public void createTableWordSearch(SQLiteDatabase db) {
        db.execSQL("create table wordSearch0 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE_TYPE + " text, "+
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                STAGE_WIDTH + " integer, " +
                STAGE_HEIGHT + " integer, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table wordSearch1 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE_TYPE + " text, "+
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                STAGE_WIDTH + " integer, " +
                STAGE_HEIGHT + " integer, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table wordSearch2 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE_TYPE + " text, "+
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                STAGE_WIDTH + " integer, " +
                STAGE_HEIGHT + " integer, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("insert into wordSearch0 (ID, name, type, stage, save, extra, width, height, complete) VALUES ('200','wordSearch 1', " +
                "'0000001000100010112121211121101011222010000100100000012100000010'," +
                "'ELAVGOWWCGFXQZÓQKRABŻÓŁWMURJEFPXMETALQOBGUYDKETXCAJCUSOKFVAFPGPK'," +
                "'0000000000000000000000000000000000000000000000000000000000000000/0000000000','FART/MUR/KRAB/METAL/ŻEL/JAD/ŻÓŁW/WÓŁ/SOK/POTOP',8,8,'false');");
        db.execSQL("insert into wordSearch0 (ID, name, type, stage, save, extra, width, height, complete) VALUES ('300','wordSearch 2', " +
                "'000100000000000110000000000111000000000223111111010111000000121210000000011211000000010100000000011211100000'," +
                "'MJDPXGTZCKSVFVPOZOXKJPENOTZTASLHENFQCIOOKOWOCOWOARQPASFVZUSXZARAZLAMIFVLHDINNIMUJCCAAANNCGXBJJUMFRKAJAKQCADW'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000/0000000000','SOS/OKO/POTOP/ZAKAZ/OWOCOWO/ZARAZ/RADAR/ANNA/INNI/KAJAK',12,9,'false');");
        db.execSQL("insert into wordSearch0 (ID, name, type, stage, save, extra, width, height, complete) VALUES ('400','wordSearch 3', " +
                "'00001000000110000101110011122211021111000121110001111100011020001121110000101000'," +
                "'SŁLŁBEYGWYPAŁPUHEAKWYABCNRDESZCZMUGLKRAABMRUAUSHMHZOWBWDSCMFIIUNGROMCPMRHCTIALRY'," +
                "'00000000000000000000000000000000000000000000000000000000000000000000000000000000/00000000','BURZA/PIORUN/ULEWA/BŁYSKAWICA/DESZCZ/GROM/GRZMOT/CHMURA',8,10,'false');");

        db.execSQL("insert into wordSearch1 (ID, name, type, stage, save, extra, width, height, complete) VALUES ('200','wordSearch 1', " +
                "'000000000000000011100101101110010110111001011011110101111111010111111101011111110212222212000111010100011000010000111111'," +
                "'LWUHZNYNŁWRŁTZBSSKŁKICISPTIIAEIHTZOTENRRSOTERTRWENŁRNRUMŻONASĄJECAAKETLŻWGZJNŁGINYWONOTULPJŁHWIRJPFALNWYKJSYYKJDPFLARPAK'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000/0000000000','SZEREGOWY/KAPRAL/PLUTONOWY/SIERŻANT/CHORĄŻY/PORUCZNIK/KAPITAN/MAJOR/PUŁKOWNIK/GENERAŁ',10,12,'false');");
        db.execSQL("insert into wordSearch1 (ID, name, type, stage, save, extra, width, height, complete) VALUES ('300','wordSearch 2', " +
                "'0000111112000000000110321121121011100101201011001121101110022021001101102100011111101000111000010001'," +
                "'GJUSMAŚLAKSKYMWSSMUEGUKAINZCOBĄZOIKHWDWYSIŹZWŃHLYZKMLHKOEWGRABAUUSRIŁGNCRRKDSOPDIKZŁDRUJBOAHŁTAZONMP'," +
                "'0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000/00000000000','BOCZNIAK/BOROWIK/GĄSKA/KANIA/KOŹLARZ/KURKA/MAŚLAK/OPIEŃKA/PODGRZYBEK/RYDZ/SMARDZ',10,10,'false');");
        db.execSQL("insert into wordSearch1 (ID, name, type, stage, save, extra, width, height, complete) VALUES ('400','wordSearch 3', " +
                "'0000000010131211111001101000100111011110111011111011101102101111001120123111122111101111201021111100'," +
                "'SBLPMKŁHHTZPROMESAIFHORSDSCHPGGŻAONSSROILYZFWKEATBECSCEIRTENSZNNMŁZYKZKKARENCJAIEARJCESJAHWGTYDERKPA'," +
                "'0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000/000000000000','ANEKS/CESJA/HIPOTEKA/KARENCJA/KREDYT/ODSETKI/POŻYCZKA/PROMESA/PROWIZJA/RATY/TRANSZA/WEKSEL',10,10,'false');");

        db.execSQL("insert into wordSearch2 (ID, name, type, stage, save, extra, width, height, complete) VALUES ('200','wordSearch 1', " +
                "'1121111112000001000000100011211111321110020000101001001100100111000101100002000010110001100002211211010000100002001000000001010100000000000110000000000002000000000000000'," +
                "'BRATYSŁAWAŁZPGBMMMRBDPTMGOTZSEPADUBERNOYNTPRHWEANACBBYEZTBRPMYAESGMRFSLJGUGLUŁYUDDIEHŁMGETZAAANKARARISŁTFPMGGGPASDKCCYTMDCFDWKIUOAGYBFWOHJDURZRZJJŁACGUZDBNZRNOUKYGKLŁETW'," +
                "'0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000/0000000000','AMSTERDAM/ANKARA/ATENY/BELGRAD/BERLIN/BERNO/BRATYSŁAWA/BRUKSELA/BUDAPESZT/BUKARESZT',13,13,'false');");
        db.execSQL("insert into wordSearch2 (ID, name, type, stage, save, extra, width, height, complete) VALUES ('300','wordSearch 2', " +
                "'0000010000000000021121100000121111000000011010100000011121110000011000113100010010001221101011311131210100011001101010001010100011000100100000200010000000010000000000000'," +
                "'LMRDYXPELOAWPNWCUIPHONEŁGPŁHAASUSILRRONSTOLNMUGZMJCJDMRECAOIYIKWGIHNHYACTHTŁOGUKUWSLTSONYKNCBLACKBERRYKUHAOIWNURLLOHSELZKGEMPBHPLMCIWOORIDMIEZADSZNFCDMOHSYSIHUZZTSAUKEJC'," +
                "'0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000/0000000000000','ACER/ALCATEL/ASUS/BLACKBERRY/HTC/HUAWEI/IPHONE/MOTOROLA/NOKIA/PRESTIGIO/SAMSUNG/SONY/XIAOMI',13,13,'false');");
        db.execSQL("insert into wordSearch2 (ID, name, type, stage, save, extra, width, height, complete) VALUES ('400','wordSearch 3', " +
                "'121111110010131112111110111002111110110101000010110122111111111112111131110001100111110001011010110001011100000001101100001112021010'," +
                "'AICCACOFODLIATTEHCSURBANRTOGFAZZIPSWIEŁRFNGHGCAYSHŁATNELOPGGOGMINESTRONETADFZLLCWOEPTPFFELMLCBIKOSARMODCIAMWRZHWTNHJDNHNSRILOIVARYIE'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000/0000000000000','BRUSCHETTA/CANNELLONI/FOCACCIA/GNOCCHI/LASAGNE/MINESTRONE/PIADA/PIZZA/POLENTA/RAVIOLI/RISOTTO/SPAGHETTI/TORTELLINI',12,11,'false');");

    }

    public void createTableCrossword(SQLiteDatabase db) {
        db.execSQL("create table crossword0 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE_TYPE + " text, "+
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                STAGE_WIDTH + " integer, " +
                STAGE_HEIGHT + " integer, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table crossword1 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE_TYPE + " text, "+
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                STAGE_WIDTH + " integer, " +
                STAGE_HEIGHT + " integer, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table crossword2 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE_TYPE + " text, "+
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                STAGE_WIDTH + " integer, " +
                STAGE_HEIGHT + " integer, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("insert into crossword0 (ID, name, type, stage, save, extra, width, height, complete) VALUES ('200','CROSS&DOWN 1', " +
                "'-----.------.-.---.-.------.------.-.---.-.------.------.....-.-.-.---------.-.-.-.....------.------.-.---.-.------.------.-.---.-.------.-----'," +
                "'URLOP.POMOCC.A.LEE.I.HZAMKI.LEGARO.U.SKI.L.ZNISZA.KRATAA.....A.N.N.BRATANICA.O.E.R.....SDYCHA.DEDALS.I.MAZ.E.EKOTEW.WYSYPO.A.ALI.E.IKULEJ.GORCE'," +
                "'-----.------.-.---.-.------.------.-.---.-.------.------.....-.-.-.---------.-.-.-.....------.------.-.---.-.------.------.-.---.-.------.-----'," +
                "'H;0;4;Tacierzyński/H;6;10;Pierwsza - udzielana ofierze wypadku/H;15;17;Marka spodni dżinsowych/H;22;26;Na lodzie lepiej ich nie budować/H;28;32;Gruba belka podłogowa/H;37;39;Daw. narty/H;44;48;Wnęka w murze/H;50;54;Zabezpieczenie okna/H;67;75;Dawniej nazywana synowicą/H;88;92;W gwarze miejskiej dziesięciozłotówka/H;94;98;Uciekał z synem z Krety/H;103;105;Gęsta, kleista substancja/H;110;114;Łączy maszynę z fundamentem/H;116;120;Urodzaj grzybów/H;125;127;... Baba, drwal z arabskiej baśni/H;132;136;Jerzy (zm. 2012), słynny bokser/H;138;142;Pasmo górskie ze szczytem Turbacz/V;0;55;Kobieta naukowiec/V;2;46;Zbiór niepotrzebnych staroci/V;4;48;Fałda na koszuli/V;6;72;Ptak pływający z workiem u dzioba/V;8;74;Pot. nierób, cwaniak/V;10;65;Niezbędny do ćwikły/V;68;134;Solowy koncert Krzysztofa Krawczyka/V;70;136;Prowadzi go motorniczy/V;77;132;Uzyskanie dystansu/V;87;142;Oko wilka/V;94;138;Kran w porcie/V;96;140;Lody po obiedzie ',11,13,'false');");
        db.execSQL("insert into crossword0 (ID, name, type, stage, save, extra, width, height, complete) VALUES ('300','CROSS&DOWN 2', " +
                "'-----.------.-.---.-.------.------.-.---.-.------.------.-.-.-.-.------.-----.-.-.-.-.-.-----------.-.-.-.-.-.-----------.-.-.-.-.-.-----.-----'," +
                "'KOKOS.MAFIAO.O.EMU.O.RNAWOZ.SPLOTK.A.ALT.K.YRADOM.ATLASE.L.K.N.O.TTROKI.GERDA.O.R.P.S.N.SZTUKATERIA.S.S.P.N.O.STRZELECTWO.A.E.A.J.K.LWICA.CANAL'," +
                "'-----.------.-.---.-.------.------.-.---.-.------.------.-.-.-.-.------.-----.-.-.-.-.-.-----------.-.-.-.-.-.-----------.-.-.-.-.-.-----.-----'," +
                "'H;0;4;Największy orzech/H;6;10;Yakuza w Japonii/H;15;17;Australijski kuzyn strusia/H;22;26;Kompost lub azotniak/H;28;32;Połączenie kilku nerwów/H;37;39;Głos M. Forrester/H;44;48;Powiat grodzki nad Mleczną/H;50;54;Dzieło kartografa/H;66;70;Sznurki przy kitlu/H;72;76;Imię żeńskie lub zamek do drzwi/H;88;98;Gipsowa dekoracja architektoniczna/H;110;120;Sport J. Zapędzkiego/H;132;136;Elza z powieści J. Adamson /H;138;142;...+, stacja TV/V;0;66;Realna rzecz/V;2;68;Podstawa w kuźni/V;4;70;Ciastka z nasion rośliny oleistej i karmelu /V;6;72;Koń z prerii amerykańskich /V;8;74;Ludowa twórczość artystyczna/V;10;76;Np. rzeźbiarz/V;67;133;Odległość między osiami pojazdu/V;69;135;Minerał, z którego wytapia się metale/V;73;139;Najistotniejsza treść czegoś/V;75;141;Wynagrodzenie za 8 godzin pracy/V;82;126;Pot. pleciuch',11,13,'false');");
        db.execSQL("insert into crossword0 (ID, name, type, stage, save, extra, width, height, complete) VALUES ('400','CROSS&DOWN 3', " +
                "'-..-.-.-----------.-.--.--------------.-.-.--.-.-.------------.-.-.-.-.-.------------.-..-.-...------------.-..-...-.------------.-..-...-.----'," +
                "'O..P.K.ZBIRKRZESLO.R.OU.GRZYBIARZLARUM.O.C.KA.Y.A.RETROROZALIA.W.S.K.R.X.KOSZPAGANINI.T..Z.N...JARDMALZONKA.A..N...O.NOCENIEBORAK.H..E...A.ANYZ'," +
                "'-..-.-.-----------.-.--.--------------.-.-.--.-.-.------------.-.-.-.-.-.------------.-..-.-...------------.-..-...-.------------.-..-...-.----'," +
                "'H;7;10;Oprawca, bandyta /H;11;17;Stoi przy biurku/H;24;32;Zbieracz kurek/H;33;37;Przestarz. zgiełk, hałas/H;50;54;Moda z myszką/H;55;61;Solenizantka z 4 IX/H;73;76;Gondola pod balonem/H;77;84;Niccolo, wirtuoz skrzypiec/H;95;98;Krótszy od metra/H;99;106;Kobieta zamężna/H;117;120;Czerwcowe - krótkie/H;121;128;Biedaczysko, chudzina/H;139;142;Gwiazdkowaty, to badian/V;0;55;Część mikroskopu lub lunety/V;3;36;Kraj z Limą/V;5;27;Fajki dzika/V;8;74;Kurkowe stowarzyszenie/V;10;76;Najwyższy stopień przyjemności/V;13;57;Pot. kłopot/V;15;59;Pot. gotówka/V;17;61;Dawna holendernia/V;56;133;Przedstawienie dokumentu/V;58;102;Nowe opracowanie starej piosenki/V;60;82;Popularny dawniej proszek do prania/V;73;139;Larwa żaby/V;75;141;... na lachy/V;104;137;Podziemna kryjówka borsuka ',11,13,'false');");

        db.execSQL("insert into crossword1 (ID, name, type, stage, save, extra, width, height, complete) VALUES ('200','CROSS&DOWN 1', " +
                "'------.-----.-.-...-.-------.-----.-.---.-.-----.-.-----.-.---.-.-.-.-.-------------.-...-.-..-------------.-..-.-.-.------------.-..-.-.-.----'," +
                "'ZLEWKA.UDKOA.L.R...A.SSZERYF.GRATI.M.MIM.M.REMIL.N.GODYW.S.BIS.Z.G.D.B.STOJKADEPESZA.A...K.Z..RADLOSARKOFAG.A..L.R.E.AZJAKOLEKTYW.B..G.S.A.ARAB'," +
                "'------.-----.-.-...-.-------.-----.-.---.-.-----.-.-----.-.---.-.-.-.-.-------------.-...-.-..-------------.-..-.-.-.------------.-..-.-.-.----'," +
                "'H;0;5;Laboratoryjna szklanka z dziubkiem /H;7;10;Część tuszki kurczaka/H;22;27;Stróż prawa z westernu/H;29;32;Rupieć/H;37;39;Np. Marcel Marceau/H;44;47;Imię Zegadłowicza, autora „Zmór”/H;51;54;Uroczystości weselne /H;59;61;Powtórka piosenki na życzenie publiki/H;71;76;Rodzaj kołnierzyka/H;77;83;Tekst przysyłany telegraficznie/H;94;98;Wyparte przez sochę/H;99;106;Ozdobna trumna z kamienia/H;117;120;Z Mongolią, Kuwejtem/H;121;128;Zgrany zespół ludzi/H;139;142;Np. mieszkaniec Jemenu/V;0;55;Łan rosnącego żyta/V;2;57;Marka pol. telewizora/V;4;37;W przysłowiu z Rzymem/V;8;94;Pieczeniarz, pasożyt/V;10;76;Jadalny małż morski/V;27;83;Końcówka biegu/V;61;105;Tak potocznie mówimy o szefowej/V;67;133;Cykl filmów K. Kieślowskiego/V;69;135;Przestrzeń wydająca się nie mieć granic/V;95;139;Z jej soku tequila/V;97;141;Pot. stary, źle utrzymany statek/V;104;137;Uczta, sute przyjęcie',11,13,'false');");
        db.execSQL("insert into crossword1 (ID, name, type, stage, save, extra, width, height, complete) VALUES ('300','CROSS&DOWN 2', " +
                "'-.-.-----------.-.-.-.-.----.--------.---.-.-.----.-----------.-.-..-.-.----------.-.-.-.-.-.--------------.-..-.-.-.--------.---.-..-.-.-.----'," +
                "'E.N.SPIRALADZEM.L.A.I.W.FIGA.DANEAURA.ZIL.D.R.OMAM.OSADDELIKAT.Z.R..O.T.RZEPALEGIA.Y.W.Z.R.R.WBICIEROZMARYN.G..T.I.Z.DOLAHYMN.OKO.A..K.A.S.REKA'," +
                "'-.-.-----------.-.-.-.-.----.--------.---.-.-.----.-----------.-.-..-.-.----------.-.-.-.-.-.--------------.-..-.-.-.--------.---.-..-.-.-.----'," +
                "'H;4;10;Figura akrobacji lotniczej/H;11;14;Zespół muz. R. Riedla/H;24;27;Pot. nic/H;29;32;Osobowe, to personalia/H;33;36;Deszczowa - jesienią/H;38;40;Marka ros. ciężarówki/H;46;49;Przywidzenie, złudzenie/H;51;54;Fusy na dnie szklanki/H;55;61;Przyprawa uniwersalna Knorra/H;72;76;„Krzepkie” warzywo/H;77;81;Ochotniczy oddział wojska/H;93;98;Gwoździa w deskę przy użyciu młotka/H;99;106;Wiecznie zielony krzew z wargowych/H;117;120;Los przypadający komuś w udziale/H;121;124;Jest nim „Mazurek Dąbrowskiego”/H;126;128;Pętelka w sieci/H;139;142;Wkładana do kieszeni/V;0;55;Imię twórcy kabaretu Dudek/V;2;79;Specjalista od chorób nerek/V;5;60;Płynny składnik krwi; osocze/V;7;51;Wyparte przez sochę/V;9;53;Bogusław, aktor („Kroll”, „Psy”)/V;14;58;Główne miasto Florydy/V;48;81;Dokumentacja sądowa/V;52;96;Zawód J. Kilińskiego/V;54;98;Drobne okrągłe cukierki/V;61;105;Rowki na walcu lub stożku/V;78;133;Zmysłowy wiersz/V;80;135;Świętuje razem z Adamem i Ewą/V;93;137;Krzewinka o różowofioletowych kwiatach/V;95;139;Samiec z koralami/V;97;141;Jodła, sosna lub modrzew',11,13,'false');");
        db.execSQL("insert into crossword1 (ID, name, type, stage, save, extra, width, height, complete) VALUES ('400','CROSS&DOWN 3', " +
                "'-.-.---.-.------.------.-.---.-.------.------.------.-.-----.-----.-.-...-.-.-----.-----.-.------.------.------.-.---.-.------.------.-.---.-.-'," +
                "'P.P.POR.B.UERATO.ORIONR.S.LIZ.E.IKRYZA.WALIAO.WSCHOD.B.ZRAZY.ZOFIA.O.Y...P.Z.UMOWA.SCHAB.E.KNIEJA.RPOSAG.KARBYU.W.LEC.A.TMIAMI.JUCHAA.T.KRA.Z.N'," +
                "'-.-.---.-.------.------.-.---.-.------.------.------.-.-----.-----.-.-...-.-.-----.-----.-.------.------.------.-.---.-.------.------.-.---.-.-'," +
                "'H;4;6;Ujście gruczołu potowego/H;11;15;Muza z kitarą/H;17;21;Mityczny olbrzym, ukochany Eos/H;26;28; ... Taylor, grała Kleopatrę/H;33;37;Dawny okrągły kołnierz marszczony/H;39;43;Graniczy z Anglią/H;46;51;„Na ... od Edenu”, film E. Kazana/H;55;59;Danie mięsne po nelsońsku/H;61;65;Czwarta żona Władysława Jagiełły/H;77;81;Kontrakt handlowy/H;83;87;Mięso wieprzowe na kotlety/H;91;96;Wielki, gęsty las/H;99;103;Daw. majątek wnoszony mężowi przez żonę/H;105;109; Daw. określony porządek; ryzy/H;114;116;Stanisław Jerzy, poeta i satyryk/H;121;125;Główne miasto na Florydzie/H;127;131;Krew zwierzęcia/H;136;138;Spękany lód na rzece/V;0;55;Dwuczuby ptak wodny/V;2;57;W parze z aktywami/V;4;59;Sąsiedzi Czechów/V;6;61;Towaru do sklepów/V;8;41;Zewnętrzna część pni drzew/V;10;43;Żużlowcy z Leszna/V;36;102;Drucik spinający kartki w zeszycie/V;40;106;Usynowienie/V;42;86;Obok Majorki i Minorki/V;56;100;Alfa ..., włoski samochód/V;81;136;Np. Karol Darwin/V;83;138;Dział urzędu/V;85;140;Niesłusznie ściągana opłata/V;87;142;Duży, silny pies podwórzowy/V;99;132;Konkuruje z Adidasem/V;101;134;Matrymonialny pośrednik',11,13,'false');");

        db.execSQL("insert into crossword2 (ID, name, type, stage, save, extra, width, height, complete) VALUES ('200','CROSS&DOWN 1', " +
                "'.-.---------.---.-....-..-.-.-..-.-..-.---------.-.-.-..-.-.----.-..-----..------.-.----..-.-----.-.---..-.--.-.-.-----------.-..-.--.-.-.-------------..-.-'," +
                "'.P.PIASTUNKA.EGO.K....A..K.L.U..D.N..A.OKSYMORON.R.W.Z..P.N.WICI.E..ULIKE..CIRRUS.C.LAKA..O.TRYTO.U.WET..E.AD.B.A.ADAGIORAROG.C..G.IO.A.R.JUDASZMAKSYMA..E.M'," +
                "'.-.---------.---.-....-..-.-.-..-.-..-.---------.-.-.-..-.-.----.-..-----..------.-.----..-.-----.-.---..-.--.-.-.-----------.-..-.--.-.-.-------------..-.-'," +
                "'H;3;11;Dawne określenie niani/H;13;15;Świadoma część osobowości, freudowske ja/H;39;47;Figura stylistyczna będąca wewnętrzną sprzecznością/H;60;63;Wzywały kiedyś na wojnę(rozsyłać...)/H;68;71;Gatunek tłustego śledzia/H;75;80;Pierzasta chmura dobrej pogody/H;84;87;Chińska żywica do wyrobu ozdobnych przedmiotów/H;92;95;Najcięższy izotop wodoru/H;100;103;Odpłącanie tym samym/H;114;119;Wolne tempo muzyczne (przed andante)/H;120;124;Ptak drapieżny z rodziny sokołów/H;138;143;Dawniej o wizjerze/H;144;150;Złota myśl, aforyzm/V;1;61;Amerykański ssak podobny do świni/V;3;87;Dawniej o małżońce/V;5;77;Odbiera porody, położnik/V;10;95;Członkowie kapituły m.in. Długosz i Kopernik/V;32;92;Negatywne zrządznie losu rozumiane jako Boży wyrok/V;60;144;Owalny tor kolarski/V;78;150;Obieg, cyrkulacja(lub częsta wymiana pracowników)/V;86;146;Dawniej męski kontusz/V;93;153;Muzyka Boba Marleya/V;95;155;Kierunek filozoficzno-regiligny w Chinach/V;100;148;Łojowe wykwity skórne',12,13,'false');");
        db.execSQL("insert into crossword2 (ID, name, type, stage, save, extra, width, height, complete) VALUES ('300','CROSS&DOWN 2', " +
                "'--------.-.--...-..-------------.-.--.-.-..----.--------.-.--...-.----------..-..-.-..-.-------------.-.-..--.-.---------.-.-.-.-..--------.-----.-.-...-...'," +
                "'SEMANTYK.H.RY...A..OKOWYMEMORIAL.L.TP.I.O..AZUR.TOROWIEC.B.PO...Y.SZPICAMYTO..K..E.R..R.GRADACJAGRAAL.P.R..LU.K.OBIEKCJEL.T.R.Z.A..LATAWIZM.NIWAG.T.A...A...'," +
                "'--------.-.--...-..-------------.-.--.-.-..----.--------.-.--...-.----------..-..-.-..-.-------------.-.-..--.-.---------.-.-.-.-..--------.-----.-.-...-...'," +
                "'H;0;7;Językowznawca badający znaczenia słow/H;19;23;Żelazne pęta, kajdany/H;24;31;Zawody sportowe w celu uczczenia czyjejś pamieci/H;43;46;Wzor haftu tworzony przez układ otworów/H;48;55;Kolarz na welodromie/H;66;71;Straż przednia ubezpieczająca kolumnę wojska/H;72;75;Średniowieczna opłata na rogatkach miasta/H;88;95;Stopniowe nasilanie(...rosnąca) lub słabnięcie (malejąca)/H;96;100;Legendarny kielich z Ostatniej Wieczerzy/H;112;119;Wątpliwości z zastrzeżeniami/H;132;138;Występowanie u osobnika cech jego odległych przodków/H;140;143;Poetycko o ziemi uprawnej/V;0;72;Objaw, oznaka/V;4;64;Nawyki, zwykle te złe/V;7;67;Pszenny placek/V;9;93;Wycinany w tańcu, podskok z uderzeniem obcasu o obcas/V;11;35;Wykonywany za pomocą rylca w twardym materiale/V;26;50;...domowy- wolność niezakłóconego korzystania z domu/V;54;138;Ucieczka pod rzeczywistości i problemów współczesności/V;59;143;Zestawienie podobnieństw, analogia/V;74;146;Umowa międzynarodowa lub dzieło naukowe/V;88;148;Chwała(skojarz z kolędą)/V;92;152;Tajniki wiedzy zgłębiane przez adepta/V;96;144;Obóz przymusowej pracy w ZSSR',12,13,'false');");
        db.execSQL("insert into crossword2 (ID, name, type, stage, save, extra, width, height, complete) VALUES ('400','CROSS&DOWN 3', " +
                "'-.-.-----------.-.-.-.-.-----------.-.-.-.-.-------.------.-------.-.-.-.-.-----------.-.-.-.-.-----------.-.-'," +
                "'O.D.SIKORABAROK.L.O.O.A.WIEZBAKOBRA.B.A.N.I.RZEPKAA.NIEMKA.BSKALKI.N.O.O.A.OSCARKRAWAT.E.D.A.K.KORBAOBRAZA.Z.Ż'," +
                "'-.-.-----------.-.-.-.-.-----------.-.-.-.-.-------.------.-------.-.-.-.-.-----------.-.-.-.-.-----------.-.-'," +
                "'H;4;9;Ptak wielkości wróbla lubiący słoninę/H;10;14;1 z 5 anagramów z liter A,B,K,O,R (na B)/H;24;29;Konstrukcja nośna dachu z domku/H;30;34;1 z 5 anagramów z liter A,B,K,O,R (na K)/H;44;49;Zasadził ją dziadek w ogrodzie(w wierszu Tuwima)/H;52;57;Mieszkanka Drezna lub Hamburga/H;60;65;Do wspinania w wysokich górach/H;75;79;Amerykańska nagroda, marzenie każdego aktora/H;80;85;Wiązany pod szyją/H;95;99;1 z 5 anagramów z liter A,B,K,O,R (na K)/H;100;105;Obelga, zniewaga/V;0;60;Przebój Czesława Niemena(dwa słowa, Gdzieś ...,... życia nurt/V;2;62;Z conajmniej kilkoma szczeblami/V;4;64;Wysmażony kawałek słoniny/V;6;56;Do niego  można trafić po nitce/V;8;48;1 z 5 anagramów z liter A,B,K,O,R (na R)/V;45;105;Niewielka szczotka, w parze z szufelką/V;47;107;Ochrania żółwia i rycerza/V;49;109;Dawna forma walki okrętów(ze sczpianiem burtami)/V;53;103;Przepływa przez jez.Jeziorak/V;61;101;1 z 5 anagramów z liter A,B,K,O,R (na K)',10,10,'false');");

    }

    public void createTableSudoku(SQLiteDatabase db) {
        db.execSQL("create table normalSudoku0 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table normalSudoku1 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table normalSudoku2 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table unNormalSudoku0 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE_TYPE + " text, "+
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                STAGE_WIDTH + " integer, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table unNormalSudoku1 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE_TYPE + " text, "+
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                STAGE_WIDTH + " integer, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("create table unNormalSudoku2 ( " +
                STAGE_ID + " text primary key not null, " +
                STAGE_NAME + " text, " +
                STAGE_TYPE + " text, "+
                STAGE + " text, " +
                STAGE_SAVE + " text, " +
                STAGE_EXTRA + " text, " +
                STAGE_WIDTH + " integer, " +
                COMPLETE + " text " +
                ")");

        db.execSQL("insert into normalSudoku0 (ID, name, stage, save, extra, complete) VALUES ('200','Simple 1'," +
                "'000080009000426130000901506200830974309060080000294000056310000000000807084052010'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000','false');");
        db.execSQL("insert into normalSudoku0 (ID, name, stage, save, extra, complete) VALUES ('300','Simple 2', " +
                "'000840397300005000070200005024500039003476010800903450000002800506300901702000000'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000','false');");
        db.execSQL("insert into normalSudoku0 (ID, name, stage, save, extra, complete) VALUES ('400','Simple 3', " +
                "'704951002000067504125000096007000200900400305000135000000324000090008060450000103'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000','false');");

        db.execSQL("insert into normalSudoku1 (ID, name, stage, save, extra, complete) VALUES ('200','Medium 1', " +
                "'020519000050700010060200900685023000000000802070140000701000059000001007030490021'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000','false');");
        db.execSQL("insert into normalSudoku1 (ID, name, stage, save, extra, complete) VALUES ('300','Medium 2', " +
                "'200036000000008017004005003007029100001300964038001000010750000003090040049000070'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000','false');");
        db.execSQL("insert into normalSudoku1 (ID, name, stage, save, extra, complete) VALUES ('400','Medium 3', " +
                "'080070050430090700790638001060004009140000000070002038900000105000500000003900000'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000','false');");

        db.execSQL("insert into normalSudoku2 (ID, name, stage, save, extra, complete) VALUES ('200','Hard 1', " +
                "'200000951000000007876005200304028000000000509005001304020084010000010098000000000'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000','false');");
        db.execSQL("insert into normalSudoku2 (ID, name, stage, save, extra, complete) VALUES ('300','Hard 2', " +
                "'000815000050000076030200000000000098200050000473002000081300402004000109005024000'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000','false');");
        db.execSQL("insert into normalSudoku2 (ID, name, stage, save, extra, complete) VALUES ('400','Hard 3', " +
                "'008000000010000500003401800000500003000723010405000060000847000000030172600090000'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000'," +
                "'000000000000000000000000000000000000000000000000000000000000000000000000000000000','false');");

        db.execSQL("insert into unNormalSudoku0 (ID, name, type, stage, save, extra, width, complete) VALUES ('200','6x6 1', " +
                "'000111000111222333222333444555444555'," +
                "'050001004600400050100004043000060240'," +
                "'000000000000000000000000000000000000'," +
                "'000000000000000000000000000000000000',6,'false');");
        db.execSQL("insert into unNormalSudoku0 (ID, name, type, stage, save, extra, width, complete) VALUES ('300','6x6 2', " +
                "'000111000111222333222333444555444555'," +
                "'034000000024053000400105601200000041'," +
                "'000000000000000000000000000000000000'," +
                "'000000000000000000000000000000000000',6,'false');");
        db.execSQL("insert into unNormalSudoku0 (ID, name, type, stage, save, extra, width, complete) VALUES ('400','6x6 3', " +
                "'000111000111222333222333444555444555'," +
                "'504000600035120000000600001003403062'," +
                "'000000000000000000000000000000000000'," +
                "'000000000000000000000000000000000000',6,'false');");

        db.execSQL("insert into unNormalSudoku1 (ID, name, type, stage, save, extra, width, complete) VALUES ('200','6x6 1', " +
                "'000111000111222333222333444555444555'," +
                "'030605040000300000000360502006000501'," +
                "'000000000000000000000000000000000000'," +
                "'000000000000000000000000000000000000',6,'false');");
        db.execSQL("insert into unNormalSudoku1 (ID, name, type, stage, save, extra, width, complete) VALUES ('300','6x6 2', " +
                "'000111000111222333222333444555444555'," +
                "'102000000030060200000403050004400601'," +
                "'000000000000000000000000000000000000'," +
                "'000000000000000000000000000000000000',6,'false');");
        db.execSQL("insert into unNormalSudoku1 (ID, name, type, stage, save, extra, width, complete) VALUES ('400','6x6 3', " +
                "'000111000111222333222333444555444555'," +
                "'000013102000006500200301000006050030'," +
                "'000000000000000000000000000000000000'," +
                "'000000000000000000000000000000000000',6,'false');");

        db.execSQL("insert into unNormalSudoku2 (ID, name, type, stage, save, extra, width, complete) VALUES ('200','6x6 1', " +
                "'000111000111222333222333444555444555'," +
                "'506000000020060000000501004000000103'," +
                "'000000000000000000000000000000000000'," +
                "'000000000000000000000000000000000000',6,'false');");
        db.execSQL("insert into unNormalSudoku2 (ID, name, type, stage, save, extra, width, complete) VALUES ('300','6x6 2', " +
                "'000111000111222333222333444555444555'," +
                "'006040000500030001400003004010000600'," +
                "'000000000000000000000000000000000000'," +
                "'000000000000000000000000000000000000',6,'false');");
        db.execSQL("insert into unNormalSudoku2 (ID, name, type, stage, save, extra, width, complete) VALUES ('400','6x6 3', " +
                "'000111000111222333222333444555444555'," +
                "'106000000003000500053020000260010000'," +
                "'000000000000000000000000000000000000'," +
                "'000000000000000000000000000000000000',6,'false');");
    }

    public void dropTable(SQLiteDatabase db){
        dropTableSudoku(db);
        dropTableCrossword(db);
        dropTableWordSearch(db);
        dropTableHangman(db);
        dropTableGuessWork(db);
    }

    public void dropTableGuessWork(SQLiteDatabase db) {
        db.execSQL("drop Table guessWork0;");
        db.execSQL("drop Table guessWork1;");
        db.execSQL("drop Table guessWork2;");
    }

    public void dropTableHangman(SQLiteDatabase db) {
        db.execSQL("drop Table hangman0;");
        db.execSQL("drop Table hangman1;");
        db.execSQL("drop Table hangman2;");

    }

    public void dropTableWordSearch(SQLiteDatabase db) {
        db.execSQL("drop Table wordSearch0;");
        db.execSQL("drop Table wordSearch1;");
        db.execSQL("drop Table wordSearch2;");
    }

    public void dropTableCrossword(SQLiteDatabase db) {
        db.execSQL("drop Table crossword0;");
        db.execSQL("drop Table crossword1;");
        db.execSQL("drop Table crossword2;");
    }

    public void dropTableSudoku(SQLiteDatabase db) {
        db.execSQL("drop Table normalSudoku0;");
        db.execSQL("drop Table normalSudoku1;");
        db.execSQL("drop Table normalSudoku2;");

        db.execSQL("drop Table unNormalSudoku0;");
        db.execSQL("drop Table unNormalSudoku1;");
        db.execSQL("drop Table unNormalSudoku2;");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
