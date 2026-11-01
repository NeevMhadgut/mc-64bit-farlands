public class EntityAIBreakDoor extends EntityAIDoorInteract {
   private int i;

   public EntityAIBreakDoor(EntityLiving par1EntityLiving) {
      super(par1EntityLiving);
   }

   @Override
   public boolean a() {
      return !super.a() ? false : !this.e.func_48213_h(this.a.k, this.b, this.c, this.d);
   }

   @Override
   public void c() {
      super.c();
      this.i = 240;
   }

   @Override
   public boolean b() {
      double d = this.a.f(this.b, this.c, this.d);
      return this.i >= 0 && !this.e.func_48213_h(this.a.k, this.b, this.c, this.d) && d < 4.0;
   }

   @Override
   public void e() {
      super.e();
      if (this.a.aO().nextInt(20) == 0) {
         this.a.k.playAuxSFX(1010, this.b, this.c, this.d, 0);
      }

      if (--this.i == 0 && this.a.k.q == 3) {
         this.a.k.setBlockWithNotify(this.b, this.c, this.d, 0);
         this.a.k.playAuxSFX(1012, this.b, this.c, this.d, 0);
         this.a.k.playAuxSFX(2001, this.b, this.c, this.d, this.e.bO);
      }
   }
}
