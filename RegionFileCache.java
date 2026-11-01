import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class RegionFileCache {
   private static final Map a = new HashMap();

   private RegionFileCache() {
   }

   public static synchronized lz createOrLoadRegionFile(File par0File, long par1, long par2) {
      File file = new File(par0File, "region");
      File file1 = new File(file, "r." + (par1 >> 5) + "." + (par2 >> 5) + ".mca");
      Reference reference = (Reference)a.get(file1);
      if (reference != null) {
         lz regionfile = (lz)reference.get();
         if (regionfile != null) {
            return regionfile;
         }
      }

      if (!file.exists()) {
         file.mkdirs();
      }

      if (a.size() >= 256) {
         a();
      }

      lz regionfile1 = new lz(file1);
      a.put(file1, new SoftReference<>(regionfile1));
      return regionfile1;
   }

   public static synchronized void a() {
      for (Reference reference : a.values()) {
         try {
            lz regionfile = (lz)reference.get();
            if (regionfile != null) {
               regionfile.a();
            }
         } catch (IOException ioexception) {
            ioexception.printStackTrace();
         }
      }

      a.clear();
   }

   public static DataInputStream getChunkInputStream(File par0File, long par1, long par2) {
      lz regionfile = createOrLoadRegionFile(par0File, par1, par2);
      return regionfile.a((int)(par1 & 31L), (int)(par2 & 31L));
   }

   public static DataOutputStream getChunkOutputStream(File par0File, long par1, long par2) {
      lz regionfile = createOrLoadRegionFile(par0File, par1, par2);
      return regionfile.b((int)(par1 & 31L), (int)(par2 & 31L));
   }
}
