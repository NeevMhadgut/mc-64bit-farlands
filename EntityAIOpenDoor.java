public class EntityAIOpenDoor extends EntityAIDoorInteract {
   boolean i;
   int j;

   public EntityAIOpenDoor(EntityLiving par1EntityLiving, boolean par2) {
      super(par1EntityLiving);
      this.a = par1EntityLiving;
      this.i = par2;
   }

   @Override
   public boolean b() {
      return this.i && this.j > 0 && super.b();
   }

   @Override
   public void c() {
      this.j = 20;
      this.e.onPoweredBlockChange(this.a.k, this.b, this.c, this.d, true);
   }

   public void d() {
      if (this.i) {
         this.e.onPoweredBlockChange(this.a.k, this.b, this.c, this.d, false);
      }
   }

   @Override
   public void e() {
      this.j--;
      super.e();
   }
}
