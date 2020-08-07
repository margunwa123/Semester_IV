import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChunkLoader implements Runnable {
  // ... Anda boleh menambahkan atribut
  private Chunk chunk;
  private String chunkDataFilename;
  public ChunkLoader(Chunk chunk, String chunkDataFilename) {
      this.chunk = chunk;
      this.chunkDataFilename = chunkDataFilename;
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
      CSVReader reader;
      try {
        reader = new CSVReader(this.chunkDataFilename, ",");
        reader.setSkipHeader(true);
      
        List<String[]> positions = reader.read();
        for(String[] positionString : positions) {
          Position position = new Position(Integer.parseInt(positionString[0]), Integer.parseInt(positionString[1]));
          this.chunk.addTree(position);
        }
      } 
      catch(IOException IOE) { return; }
      
  }
}