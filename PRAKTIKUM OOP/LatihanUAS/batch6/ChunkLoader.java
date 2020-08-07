import java.io.IOException;
import java.util.List;

public class ChunkLoader implements Runnable {
    // ... Anda boleh menambahkan atribut
    private Chunk chunk;
    private String chunkDataFileName;

    public ChunkLoader(Chunk chunk, String chunkDataFilename) {
        // ... Isilah constructor sesuai kebutuhan
        this.chunk = chunk;
        this.chunkDataFileName = chunkDataFilename;
    }

    @Override
    public void run() {
        // Membaca file dengan nama chunkDataFilename
        // Gunakan class CSVReader.
        // Contoh file chunkDataFilename:
        // x,y
        // 1,18
        // 10,8
        // 6,12
        // Untuk setiap x dan y, tambahkan tree ke Chunk
        // Jika ada IOException pada saat membaca reader, catch Exception
        // tidak ada tree yang ditambahkan pada Chunk (tidak dithrow lagi)
        try {
            CSVReader csvReader = new CSVReader(this.chunkDataFileName , ",");
            csvReader.setSkipHeader(true);
            List<String[]> chunkDatas = csvReader.read();
            for(String[] chunkData : chunkDatas) {
                this.chunk.addTree(new Position(Integer.parseInt(chunkData[0]) , Integer.parseInt(chunkData[1])));
            }
        }
        catch (IOException E) {
            
        }
    }
}