public abstract class WorldProvider {
   public World a;
   public vx b;
   public WorldChunkManager c;
   public boolean d = false;
   public boolean e = false;
   public float[] f = new float[16];
   public int g = 0;
   private float[] h = new float[4];

   public final void a(World par1World) {
      this.a = par1World;
      this.b = par1World.B().t();
      this.a();
      this.i();
   }

   protected void i() {
      float f = 0.0F;

      for (int i = 0; i <= 15; i++) {
         float f1 = 1.0F - i / 15.0F;
         this.f[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
      }
   }

   protected void a() {
      if (this.a.B().t() == vx.c) {
         this.c = new WorldChunkManagerHell(BiomeGenBase.c, 0.5F, 0.5F);
      } else {
         this.c = new WorldChunkManager(this.a);
      }
   }

   public IChunkProvider b() {
      return this.b == vx.c ? new ChunkProviderFlat(this.a, this.a.v(), this.a.B().r()) : new ChunkProviderGenerate(this.a, this.a.v(), this.a.B().r());
   }

   public boolean canCoordinateBeSpawn(long par1, long par2) {
      int i = this.a.getFirstUncoveredBlock(par1, par2);
      return i == Block.u.bO;
   }

   public float a(long par1, float par3) {
      int i = (int)(par1 % 24000L);
      float f = (i + par3) / 24000.0F - 0.25F;
      if (f < 0.0F) {
         f++;
      }

      if (f > 1.0F) {
         f--;
      }

      float f1 = f;
      f = 1.0F - (float)((Math.cos(f * Math.PI) + 1.0) / 2.0);
      return f1 + (f - f1) / 3.0F;
   }

   public int b(long par1, float par3) {
      return (int)(par1 / 24000L) % 8;
   }

   public boolean e() {
      return true;
   }

   public float[] a(float par1, float par2) {
      float f = 0.4F;
      float f1 = MathHelper.b(par1 * (float) Math.PI * 2.0F) - 0.0F;
      float f2 = -0.0F;
      if (f1 >= f2 - f && f1 <= f2 + f) {
         float f3 = (f1 - f2) / f * 0.5F + 0.5F;
         float f4 = 1.0F - (1.0F - MathHelper.a(f3 * (float) Math.PI)) * 0.99F;
         f4 *= f4;
         this.h[0] = f3 * 0.3F + 0.7F;
         this.h[1] = f3 * f3 * 0.7F + 0.2F;
         this.h[2] = f3 * f3 * 0.0F + 0.2F;
         this.h[3] = f4;
         return this.h;
      } else {
         return null;
      }
   }

   public bo b(float par1, float par2) {
      float f = MathHelper.b(par1 * (float) Math.PI * 2.0F) * 2.0F + 0.5F;
      if (f < 0.0F) {
         f = 0.0F;
      }

      if (f > 1.0F) {
         f = 1.0F;
      }

      float f1 = 0.7529412F;
      float f2 = 0.8470588F;
      float f3 = 1.0F;
      f1 *= f * 0.94F + 0.06F;
      f2 *= f * 0.94F + 0.06F;
      f3 *= f * 0.91F + 0.09F;
      return bo.b(f1, f2, f3);
   }

   public boolean d() {
      return true;
   }

   public static WorldProvider a(int par0) {
      if (par0 == -1) {
         return new WorldProviderHell();
      } else if (par0 == 0) {
         return new ms();
      } else {
         return par0 == 1 ? new WorldProviderEnd() : null;
      }
   }

   public float f() {
      return 128.0F;
   }

   public boolean c() {
      return true;
   }

   public ChunkCoordinates g() {
      return null;
   }

   public int h() {
      return this.b != vx.c ? 64 : 4;
   }

   public boolean j() {
      return this.b != vx.c && !this.e;
   }

   public double k() {
      return 1.0;
   }

   public boolean func_48218_b(long par1, long par2) {
      return false;
   }
}
