public class MovingObjectPosition {
   public aat a;
   public long b;
   public int c;
   public long d;
   public int e;
   public bo f;
   public Entity g;

   public MovingObjectPosition(long par1, int par2, long par3, int par4, bo par5Vec3D) {
      this.a = aat.a;
      this.b = par1;
      this.c = par2;
      this.d = par3;
      this.e = par4;
      this.f = bo.b(par5Vec3D.a, par5Vec3D.b, par5Vec3D.c);
   }

   public MovingObjectPosition(Entity par1Entity) {
      this.a = aat.b;
      this.g = par1Entity;
      this.f = bo.b(par1Entity.o, par1Entity.p, par1Entity.q);
   }
}
