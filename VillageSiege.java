public class VillageSiege {
   private World a;
   private boolean b = false;
   private int c = -1;
   private int d;
   private int e;
   private Village f;
   private long g;
   private int h;
   private long i;

   public VillageSiege(World par1World) {
      this.a = par1World;
   }

   public void a() {
      boolean flag = false;
      if (flag) {
         if (this.c == 2) {
            this.d = 100;
            return;
         }
      } else {
         if (this.a.m()) {
            this.c = 0;
            return;
         }

         if (this.c == 2) {
            return;
         }

         if (this.c == 0) {
            float f = this.a.c(0.0F);
            if (f < 0.5 || f > 0.501) {
               return;
            }

            this.c = this.a.r.nextInt(10) != 0 ? 2 : 1;
            this.b = false;
            if (this.c == 2) {
               return;
            }
         }
      }

      if (!this.b) {
         if (!this.b()) {
            return;
         }

         this.b = true;
      }

      if (this.e > 0) {
         this.e--;
      } else {
         this.e = 2;
         if (this.d > 0) {
            this.c();
            this.d--;
         } else {
            this.c = 2;
         }
      }
   }

   private boolean b() {
      for (EntityPlayer entityplayer : this.a.d) {
         this.f = this.a.A.findNearestVillage((long)entityplayer.o, (int)entityplayer.p, (long)entityplayer.q, 1);
         if (this.f != null && this.f.c() >= 10 && this.f.d() >= 20 && this.f.e() >= 20) {
            ChunkCoordinates chunkcoordinates = this.f.a();
            float f = this.f.b();
            boolean flag = false;

            for (int i = 0; i < 10; i++) {
               this.g = chunkcoordinates.a + (long)(MathHelper.b(this.a.r.nextFloat() * (float) Math.PI * 2.0F) * f * 0.9);
               this.h = chunkcoordinates.b;
               this.i = chunkcoordinates.c + (long)(MathHelper.a(this.a.r.nextFloat() * (float) Math.PI * 2.0F) * f * 0.9);
               flag = false;

               for (Village village : this.a.A.b()) {
                  if (village != this.f && village.isInRange(this.g, this.h, this.i)) {
                     flag = true;
                     break;
                  }
               }

               if (!flag) {
                  break;
               }
            }

            if (flag) {
               return false;
            }

            bo vec3d = this.func_48572_a(this.g, this.h, this.i);
            if (vec3d != null) {
               this.e = 0;
               this.d = 20;
               return true;
            }
         }
      }

      return false;
   }

   private boolean c() {
      bo vec3d = this.func_48572_a(this.g, this.h, this.i);
      if (vec3d == null) {
         return false;
      }

      EntityZombie entityzombie;
      try {
         entityzombie = new EntityZombie(this.a);
      } catch (Exception exception) {
         exception.printStackTrace();
         return false;
      }

      entityzombie.c(vec3d.a, vec3d.b, vec3d.c, this.a.r.nextFloat() * 360.0F, 0.0F);
      this.a.a(entityzombie);
      ChunkCoordinates chunkcoordinates = this.f.a();
      entityzombie.setHomeArea(chunkcoordinates.a, chunkcoordinates.b, chunkcoordinates.c, this.f.b());
      return true;
   }

   private bo func_48572_a(long par1, int par2, long par3) {
      for (int i = 0; i < 10; i++) {
         long j = par1 + this.a.r.nextInt(16) - 8L;
         int k = par2 + this.a.r.nextInt(6) - 3;
         long l = par3 + this.a.r.nextInt(16) - 8L;
         if (this.f.isInRange(j, k, l) && SpawnerAnimals.canCreatureTypeSpawnAtLocation(acf.a, this.a, j, k, l)) {
            return bo.b(j, k, l);
         }
      }

      return null;
   }
}
