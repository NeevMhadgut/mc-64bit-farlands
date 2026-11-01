import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Explosion {
   public boolean a = false;
   private Random h = new Random();
   private World i;
   public double b;
   public double c;
   public double d;
   public Entity e;
   public float f;
   public Set g = new HashSet();

   public Explosion(World par1World, Entity par2Entity, double par3, double par5, double par7, float par9) {
      this.i = par1World;
      this.e = par2Entity;
      this.f = par9;
      this.b = par3;
      this.c = par5;
      this.d = par7;
   }

   public void a() {
      float f = this.f;
      int i = 16;

      for (int j = 0; j < i; j++) {
         for (int l = 0; l < i; l++) {
            for (int j1 = 0; j1 < i; j1++) {
               if (j == 0 || j == i - 1 || l == 0 || l == i - 1 || j1 == 0 || j1 == i - 1) {
                  double d = j / (i - 1.0F) * 2.0F - 1.0F;
                  double d1 = l / (i - 1.0F) * 2.0F - 1.0F;
                  double d2 = j1 / (i - 1.0F) * 2.0F - 1.0F;
                  double d3 = Math.sqrt(d * d + d1 * d1 + d2 * d2);
                  d /= d3;
                  d1 /= d3;
                  d2 /= d3;
                  float f1 = this.f * (0.7F + this.i.r.nextFloat() * 0.6F);
                  double d5 = this.b;
                  double d7 = this.c;
                  double d9 = this.d;

                  for (float f2 = 0.3F; !(f1 <= 0.0F); f1 -= f2 * 0.75F) {
                     long l2 = MathHelper.d(d5);
                     int i3 = MathHelper.c(d7);
                     long j3 = MathHelper.d(d9);
                     int k3 = this.i.getBlockId(l2, i3, j3);
                     if (k3 > 0) {
                        f1 -= (Block.m[k3].a(this.e) + 0.3F) * f2;
                     }

                     if (f1 > 0.0F) {
                        this.g.add(new ChunkPosition(l2, i3, j3));
                     }

                     d5 += d * f2;
                     d7 += d1 * f2;
                     d9 += d2 * f2;
                  }
               }
            }
         }
      }

      this.f *= 2.0F;
      long k = MathHelper.d(this.b - this.f - 1.0);
      long i1 = MathHelper.d(this.b + this.f + 1.0);
      int k1 = MathHelper.c(this.c - this.f - 1.0);
      int l1 = MathHelper.c(this.c + this.f + 1.0);
      long i2 = MathHelper.d(this.d - this.f - 1.0);
      long j2 = MathHelper.d(this.d + this.f + 1.0);
      List list = this.i.b(this.e, AxisAlignedBB.b(k, k1, i2, i1, l1, j2));
      bo vec3d = bo.b(this.b, this.c, this.d);

      for (int k2 = 0; k2 < list.size(); k2++) {
         Entity entity = (Entity)list.get(k2);
         double d4 = entity.g(this.b, this.c, this.d) / this.f;
         if (d4 <= 1.0) {
            double d6 = entity.o - this.b;
            double d8 = entity.p - this.c;
            double d10 = entity.q - this.d;
            double d11 = MathHelper.a(d6 * d6 + d8 * d8 + d10 * d10);
            d6 /= d11;
            d8 /= d11;
            d10 /= d11;
            double d12 = this.i.a(vec3d, entity.y);
            double d13 = (1.0 - d4) * d12;
            entity.a(md.l, (int)((d13 * d13 + d13) / 2.0 * 8.0 * this.f + 1.0));
            double d14 = d13;
            entity.r += d6 * d14;
            entity.s += d8 * d14;
            entity.t += d10 * d14;
         }
      }

      this.f = f;
      ArrayList arraylist = new ArrayList();
      arraylist.addAll(this.g);
   }

   public void a(boolean par1) {
      this.i.a(this.b, this.c, this.d, "random.explode", 4.0F, (1.0F + (this.i.r.nextFloat() - this.i.r.nextFloat()) * 0.2F) * 0.7F);
      this.i.a("hugeexplosion", this.b, this.c, this.d, 0.0, 0.0, 0.0);
      ArrayList arraylist = new ArrayList();
      arraylist.addAll(this.g);

      for (int i = arraylist.size() - 1; i >= 0; i--) {
         ChunkPosition chunkposition = (ChunkPosition)arraylist.get(i);
         long k = chunkposition.a;
         int i1 = chunkposition.b;
         long k1 = chunkposition.c;
         int i2 = this.i.getBlockId(k, i1, k1);
         if (par1) {
            double d = (double)k + this.i.r.nextFloat();
            double d1 = (double)i1 + this.i.r.nextFloat();
            double d2 = (double)k1 + this.i.r.nextFloat();
            double d3 = d - this.b;
            double d4 = d1 - this.c;
            double d5 = d2 - this.d;
            double d6 = MathHelper.a(d3 * d3 + d4 * d4 + d5 * d5);
            d3 /= d6;
            d4 /= d6;
            d5 /= d6;
            double d7 = 0.5 / (d6 / this.f + 0.1);
            d7 *= this.i.r.nextFloat() * this.i.r.nextFloat() + 0.3F;
            d3 *= d7;
            d4 *= d7;
            d5 *= d7;
            this.i.a("explode", (d + this.b * 1.0) / 2.0, (d1 + this.c * 1.0) / 2.0, (d2 + this.d * 1.0) / 2.0, d3, d4, d5);
            this.i.a("smoke", d, d1, d2, d3, d4, d5);
         }

         if (i2 > 0) {
            Block.m[i2].dropBlockAsItemWithChance(this.i, k, i1, k1, this.i.getBlockMetadata(k, i1, k1), 0.3F, 0);
            this.i.setBlockWithNotify(k, i1, k1, 0);
            Block.m[i2].onBlockDestroyedByExplosion(this.i, k, i1, k1);
         }
      }

      if (this.a) {
         for (int j = arraylist.size() - 1; j >= 0; j--) {
            ChunkPosition chunkposition1 = (ChunkPosition)arraylist.get(j);
            long l = chunkposition1.a;
            int j1 = chunkposition1.b;
            long l1 = chunkposition1.c;
            int j2 = this.i.getBlockId(l, j1, l1);
            int k2 = this.i.getBlockId(l, j1 - 1, l1);
            if (j2 == 0 && Block.n[k2] && this.h.nextInt(3) == 0) {
               this.i.setBlockWithNotify(l, j1, l1, Block.ar.bO);
            }
         }
      }
   }
}
