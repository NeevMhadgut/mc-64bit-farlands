import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class WorldRenderer {
   public World a;
   private int y = -1;
   private static Tessellator z = Tessellator.a;
   public static int b = 0;
   public long c;
   public int d;
   public long e;
   public long f;
   public int g;
   public long h;
   public long i;
   public int j;
   public long k;
   public boolean l = false;
   public boolean[] m = new boolean[2];
   public long n;
   public int o;
   public long p;
   public boolean q;
   public AxisAlignedBB r;
   public int s;
   public boolean t = true;
   public boolean u;
   public int v;
   public boolean w;
   private boolean A = false;
   public List x = new ArrayList();
   private List B;
   private int C;

   public WorldRenderer(World par1World, List par2List, long par3, int par4, long par5, int par6) {
      this.a = par1World;
      this.B = par2List;
      this.y = par6;
      this.c = -999L;
      this.setPosition(par3, par4, par5);
      this.q = false;
   }

   public void setPosition(long par1, int par2, long par3) {
      if (par1 != this.c || par2 != this.d || par3 != this.e) {
         this.b();
         this.c = par1;
         this.d = par2;
         this.e = par3;
         this.n = par1 + 8L;
         this.o = par2 + 8;
         this.p = par3 + 8L;
         this.i = par1 & 1023L;
         this.j = par2;
         this.k = par3 & 1023L;
         this.f = par1 - this.i;
         this.g = par2 - this.j;
         this.h = par3 - this.k;
         long f = 6L;
         this.r = AxisAlignedBB.a(par1 - f, par2 - f, par3 - f, par1 + 16L + f, par2 + 16 + f, par3 + 16L + f);
         GL11.glNewList(this.y + 2, 4864);
         tw.a(AxisAlignedBB.b(this.i - f, this.j - f, this.k - f, this.i + 16L + f, this.j + 16 + f, this.k + 16L + f));
         GL11.glEndList();
         this.f();
      }
   }

   private void g() {
      GL11.glTranslated(this.i, this.j, this.k);
   }

   public void a() {
      if (this.q) {
         this.q = false;
         long i = this.c;
         int j = this.d;
         long k = this.e;
         long l = this.c + 16L;
         int i1 = this.d + 16;
         long j1 = this.e + 16L;

         for (int k1 = 0; k1 < 2; k1++) {
            this.m[k1] = true;
         }

         Chunk.a = false;
         HashSet hashset = new HashSet();
         hashset.addAll(this.x);
         this.x.clear();
         int l1 = 1;
         ChunkCache chunkcache = new ChunkCache(this.a, i - l1, j - l1, k - l1, l + l1, i1 + l1, j1 + l1);
         if (!chunkcache.a()) {
            b++;
            RenderBlocks renderblocks = new RenderBlocks(chunkcache);
            this.C = 0;

            for (int i2 = 0; i2 < 2; i2++) {
               boolean flag = false;
               boolean flag1 = false;
               boolean flag2 = false;

               for (int j2 = j; j2 < i1; j2++) {
                  for (long k2 = k; k2 < j1; k2++) {
                     for (long l2 = i; l2 < l; l2++) {
                        int i3 = chunkcache.getBlockId(l2, j2, k2);
                        if (i3 > 0) {
                           if (!flag2) {
                              flag2 = true;
                              GL11.glNewList(this.y + i2, 4864);
                              GL11.glPushMatrix();
                              this.g();
                              float f = 1.000001F;
                              GL11.glTranslatef(-8.0F, -8.0F, -8.0F);
                              GL11.glScalef(f, f, f);
                              GL11.glTranslatef(8.0F, 8.0F, 8.0F);
                              z.b();
                              z.setTranslationLong(-this.c, -this.d, -this.e);
                           }

                           if (i2 == 0 && Block.m[i3].p()) {
                              TileEntity tileentity = chunkcache.getBlockTileEntity(l2, j2, k2);
                              if (TileEntityRenderer.a.a(tileentity)) {
                                 this.x.add(tileentity);
                              }
                           }

                           Block block = Block.m[i3];
                           int j3 = block.c();
                           if (j3 != i2) {
                              flag = true;
                           } else if (j3 == i2) {
                              flag1 |= renderblocks.renderBlockByRenderType(block, l2, j2, k2);
                           }
                        }
                     }
                  }
               }

               if (flag2) {
                  this.C = this.C + z.a();
                  GL11.glPopMatrix();
                  GL11.glEndList();
                  z.setTranslationLong(0L, 0L, 0L);
               } else {
                  flag1 = false;
               }

               if (flag1) {
                  this.m[i2] = false;
               }

               if (!flag) {
                  break;
               }
            }
         }

         HashSet hashset1 = new HashSet();
         hashset1.addAll(this.x);
         hashset1.removeAll(hashset);
         this.B.addAll(hashset1);
         hashset.removeAll(this.x);
         this.B.removeAll(hashset);
         this.w = Chunk.a;
         this.A = true;
      }
   }

   public double distanceToEntitySquared(Entity par1Entity) {
      double f = par1Entity.o - this.n;
      double f1 = par1Entity.p - this.o;
      double f2 = par1Entity.q - this.p;
      return f * f + f1 * f1 + f2 * f2;
   }

   public void b() {
      for (int i = 0; i < 2; i++) {
         this.m[i] = true;
      }

      this.l = false;
      this.A = false;
   }

   public void c() {
      this.b();
      this.a = null;
   }

   public int a(int par1) {
      if (!this.l) {
         return -1;
      } else {
         return !this.m[par1] ? this.y + par1 : -1;
      }
   }

   public void a(amd par1ICamera) {
      this.l = par1ICamera.a(this.r);
   }

   public void d() {
      GL11.glCallList(this.y + 2);
   }

   public boolean e() {
      return !this.A ? false : this.m[0] && this.m[1];
   }

   public void f() {
      this.q = true;
   }
}
