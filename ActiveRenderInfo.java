import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class ActiveRenderInfo {
   public static double a = 0.0;
   public static double b = 0.0;
   public static double c = 0.0;
   private static IntBuffer i = GLAllocation.d(16);
   private static FloatBuffer j = GLAllocation.e(16);
   private static FloatBuffer k = GLAllocation.e(16);
   private static FloatBuffer l = GLAllocation.e(3);
   public static float d;
   public static float e;
   public static float f;
   public static float g;
   public static float h;

   public static void a(EntityPlayer par0EntityPlayer, boolean par1) {
      GL11.glGetFloat(2982, j);
      GL11.glGetFloat(2983, k);
      GL11.glGetInteger(2978, ActiveRenderInfo.i);
      float f = (ActiveRenderInfo.i.get(0) + ActiveRenderInfo.i.get(2)) / 2;
      float f1 = (ActiveRenderInfo.i.get(1) + ActiveRenderInfo.i.get(3)) / 2;
      GLU.gluUnProject(f, f1, 0.0F, j, k, ActiveRenderInfo.i, l);
      a = l.get(0);
      b = l.get(1);
      c = l.get(2);
      int i = par1 ? 1 : 0;
      float f2 = par0EntityPlayer.v;
      float f3 = par0EntityPlayer.u;
      d = MathHelper.b(f3 * (float) Math.PI / 180.0F) * (1 - i * 2);
      ActiveRenderInfo.f = MathHelper.a(f3 * (float) Math.PI / 180.0F) * (1 - i * 2);
      g = -ActiveRenderInfo.f * MathHelper.a(f2 * (float) Math.PI / 180.0F) * (1 - i * 2);
      h = d * MathHelper.a(f2 * (float) Math.PI / 180.0F) * (1 - i * 2);
      e = MathHelper.b(f2 * (float) Math.PI / 180.0F);
   }

   public static bo a(EntityLiving par0EntityLiving, double par1) {
      double d = par0EntityLiving.l + (par0EntityLiving.o - par0EntityLiving.l) * par1;
      double d1 = par0EntityLiving.m + (par0EntityLiving.p - par0EntityLiving.m) * par1 + par0EntityLiving.I();
      double d2 = par0EntityLiving.n + (par0EntityLiving.q - par0EntityLiving.n) * par1;
      double d3 = d + a * 1.0;
      double d4 = d1 + b * 1.0;
      double d5 = d2 + c * 1.0;
      return bo.b(d3, d4, d5);
   }

   public static int a(World par0World, EntityLiving par1EntityLiving, float par2) {
      bo vec3d = a(par1EntityLiving, par2);
      ChunkPosition chunkposition = new ChunkPosition(vec3d);
      int i = par0World.getBlockId(chunkposition.a, chunkposition.b, chunkposition.c);
      if (i != 0 && Block.m[i].cd.d()) {
         float f = BlockFluid.e(par0World.getBlockMetadata(chunkposition.a, chunkposition.b, chunkposition.c)) - 0.1111111F;
         float f1 = chunkposition.b + 1 - f;
         if (vec3d.b >= f1) {
            i = par0World.getBlockId(chunkposition.a, chunkposition.b + 1, chunkposition.c);
         }
      }

      return i;
   }
}
