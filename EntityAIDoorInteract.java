public abstract class EntityAIDoorInteract extends rc {
   protected EntityLiving a;
   protected long b;
   protected int c;
   protected long d;
   protected BlockDoor e;
   boolean f;
   float g;
   float h;

   public EntityAIDoorInteract(EntityLiving par1EntityLiving) {
      this.a = par1EntityLiving;
   }

   public boolean a() {
      if (!this.a.A) {
         return false;
      }

      PathNavigate pathnavigate = this.a.aM();
      PathEntity pathentity = pathnavigate.c();
      if (pathentity != null && !pathentity.b() && pathnavigate.b()) {
         for (int i = 0; i < Math.min(pathentity.e() + 2, pathentity.d()); i++) {
            e pathpoint = pathentity.a(i);
            this.b = pathpoint.a;
            this.c = pathpoint.b + 1;
            this.d = pathpoint.c;
            if (!(this.a.f(this.b, this.a.p, this.d) > 2.25)) {
               this.e = this.func_48318_a(this.b, this.c, this.d);
               if (this.e != null) {
                  return true;
               }
            }
         }

         this.b = MathHelper.d(this.a.o);
         this.c = MathHelper.c(this.a.p + 1.0);
         this.d = MathHelper.d(this.a.q);
         this.e = this.func_48318_a(this.b, this.c, this.d);
         return this.e != null;
      } else {
         return false;
      }
   }

   public boolean b() {
      return !this.f;
   }

   public void c() {
      this.f = false;
      this.g = (float)(this.b + 0.5 - this.a.o);
      this.h = (float)(this.d + 0.5 - this.a.q);
   }

   public void e() {
      float f = (float)(this.b + 0.5 - this.a.o);
      float f1 = (float)(this.d + 0.5 - this.a.q);
      float f2 = this.g * f + this.h * f1;
      if (f2 < 0.0F) {
         this.f = true;
      }
   }

   private BlockDoor func_48318_a(long par1, int par2, long par3) {
      int i = this.a.k.getBlockId(par1, par2, par3);
      return i != Block.aE.bO ? null : (BlockDoor)Block.m[i];
   }
}
