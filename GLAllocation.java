import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class GLAllocation {
   private static List a = new ArrayList();
   private static List b = new ArrayList();

   public static synchronized int a(int par0) {
      int i = GL11.glGenLists(par0);
      a.add(i);
      a.add(par0);
      return i;
   }

   public static synchronized void a(IntBuffer par0IntBuffer) {
      GL11.glGenTextures(par0IntBuffer);

      for (int i = par0IntBuffer.position(); i < par0IntBuffer.limit(); i++) {
         b.add(par0IntBuffer.get(i));
      }
   }

   public static synchronized void b(int par0) {
      int i = a.indexOf(par0);
      GL11.glDeleteLists((Integer)a.get(i), (Integer)a.get(i + 1));
      a.remove(i);
      a.remove(i);
   }

   public static synchronized void a() {
      for (int i = 0; i < a.size(); i += 2) {
         GL11.glDeleteLists((Integer)a.get(i), (Integer)a.get(i + 1));
      }

      IntBuffer intbuffer = d(b.size());
      ((Buffer)intbuffer).flip();
      GL11.glDeleteTextures(intbuffer);

      for (int j = 0; j < b.size(); j++) {
         intbuffer.put((Integer)b.get(j));
      }

      ((Buffer)intbuffer).flip();
      GL11.glDeleteTextures(intbuffer);
      a.clear();
      b.clear();
   }

   public static synchronized ByteBuffer c(int par0) {
      return ByteBuffer.allocateDirect(par0).order(ByteOrder.nativeOrder());
   }

   public static IntBuffer d(int par0) {
      return c(par0 << 2).asIntBuffer();
   }

   public static FloatBuffer e(int par0) {
      return c(par0 << 2).asFloatBuffer();
   }

   public static DoubleBuffer createDirectDoubleBuffer(int par0) {
      return c(par0 << 4).asDoubleBuffer();
   }
}
